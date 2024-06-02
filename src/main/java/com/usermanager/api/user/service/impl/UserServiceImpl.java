package com.usermanager.api.user.service.impl;

import com.usermanager.api.user.dto.RCreateUserDto;
import com.usermanager.api.user.exception.CpfAlreadyUsedException;
import com.usermanager.api.user.model.UserModel;
import com.usermanager.api.user.repository.IUserRepository;
import com.usermanager.api.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public void create(RCreateUserDto createUserDto) {
        if (this.userRepository.existsByCpf(createUserDto.cpf())) {
            throw new CpfAlreadyUsedException();
        }

        UserModel user = new UserModel(
                createUserDto.name(),
                createUserDto.cpf(),
                createUserDto.dateBirth(),
                createUserDto.role());

        this.userRepository.save(user);
    }
}
