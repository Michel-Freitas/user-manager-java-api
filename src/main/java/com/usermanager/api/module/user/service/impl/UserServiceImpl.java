package com.usermanager.api.module.user.service.impl;

import com.usermanager.api.module.address.dto.RAddressDto;
import com.usermanager.api.module.address.model.AddressModel;
import com.usermanager.api.module.user.dto.RCreateUserDto;
import com.usermanager.api.module.user.dto.RUpdateUserDto;
import com.usermanager.api.module.user.dto.RUserDetailsDto;
import com.usermanager.api.module.user.dto.RUserDto;
import com.usermanager.api.module.user.exception.CpfAlreadyUsedException;
import com.usermanager.api.module.user.exception.DifferentUserIdsException;
import com.usermanager.api.module.user.exception.UserNotFoundException;
import com.usermanager.api.module.user.model.UserModel;
import com.usermanager.api.module.user.repository.IUserRepository;
import com.usermanager.api.module.user.service.IUserService;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserModel create(RCreateUserDto createUserDto) {
        if (this.userRepository.existsByCpf(createUserDto.cpf())) {
            throw new CpfAlreadyUsedException();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(createUserDto.password());

        AddressModel address = new AddressModel(
                createUserDto.address().street(),
                createUserDto.address().number(),
                createUserDto.address().complement(),
                createUserDto.address().city(),
                createUserDto.address().neighborhood(),
                createUserDto.address().state(),
                createUserDto.address().zipCode()
        );

        UserModel user = new UserModel(
                createUserDto.name(),
                encryptedPassword,
                createUserDto.cpf(),
                createUserDto.dateBirth(),
                createUserDto.role(),
                address);

        return this.userRepository.save(user);
    }

    @Override
    public UserModel update(Long userId, RUpdateUserDto updateUserDto) {
        if (!Objects.equals(userId, updateUserDto.id()))
            throw new DifferentUserIdsException();

        UserModel user = this.userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        user.setName(updateUserDto.name());
        user.setDateBirth(updateUserDto.dateBirth());
        user.setRole(updateUserDto.role());
        user.setStatus(updateUserDto.status());

        return this.userRepository.save(user);
    }

    @Override
    public List<RUserDto> listAll() {
        return this.userRepository.findAll().stream()
                .map(item -> new RUserDto(
                        item.getId(),
                        item.getName(),
                        item.getCpf(),
                        item.getDateBirth(),
                        item.getRole(),
                        item.getStatus()))
                .toList();
    }

    @Override
    public RUserDetailsDto details(Long id) {
        EntityGraph<UserModel> graph = this.entityManager.createEntityGraph(UserModel.class);
        graph.addAttributeNodes("address");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        UserModel user = this.entityManager.find(UserModel.class, id, hints);
        if (user == null)
            throw new UserNotFoundException();

        RAddressDto addressDto = new RAddressDto(
                user.getAddress().getId(),
                user.getAddress().getStreet(),
                user.getAddress().getNumber(),
                user.getAddress().getComplement(),
                user.getAddress().getCity(),
                user.getAddress().getNeighborhood(),
                user.getAddress().getState(),
                user.getAddress().getZipCode()
        );

        return new RUserDetailsDto(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getDateBirth(),
                user.getRole(),
                user.getStatus(),
                addressDto
        );
    }

    @Override
    public void delete(Long id) {
        UserModel user = this.userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        user.changeStatus();
        this.userRepository.save(user);
    }
}
