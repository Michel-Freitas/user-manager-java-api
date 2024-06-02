package com.usermanager.api.module.user.service.impl;

import com.usermanager.api.module.address.model.AddressModel;
import com.usermanager.api.module.user.dto.RCreateUserDto;
import com.usermanager.api.module.user.dto.RUpdateUserDto;
import com.usermanager.api.module.user.exception.CpfAlreadyUsedException;
import com.usermanager.api.module.user.exception.DifferentUserIdsException;
import com.usermanager.api.module.user.exception.UserNotFoundException;
import com.usermanager.api.module.user.model.UserModel;
import com.usermanager.api.module.user.repository.IUserRepository;
import com.usermanager.api.module.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public UserModel create(RCreateUserDto createUserDto) {
        if (this.userRepository.existsByCpf(createUserDto.cpf())) {
            throw new CpfAlreadyUsedException();
        }

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
                createUserDto.cpf(),
                createUserDto.dateBirth(),
                createUserDto.role(),
                address);

        return this.userRepository.save(user);
    }

    @Override
    public UserModel update(Long userId, RUpdateUserDto updateUserDto) {
        if (!Objects.equals(userId, updateUserDto.id())) {
            throw new DifferentUserIdsException();
        }

        UserModel user = this.userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        user.setName(updateUserDto.name());
        user.setDateBirth(updateUserDto.dateBirth());
        user.setRole(updateUserDto.role());
        user.setStatus(updateUserDto.status());

        return this.userRepository.save(user);
    }
}
