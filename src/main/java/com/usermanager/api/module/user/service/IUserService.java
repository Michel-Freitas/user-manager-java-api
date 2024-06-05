package com.usermanager.api.module.user.service;

import com.usermanager.api.module.user.dto.RUpdateUserDto;
import com.usermanager.api.module.user.dto.RUserDetailsDto;
import com.usermanager.api.module.user.dto.RUserDto;
import com.usermanager.api.module.user.model.UserModel;
import com.usermanager.api.module.user.dto.RCreateUserDto;

import java.util.List;

public interface IUserService {
    UserModel create(RCreateUserDto createUserDto);
    UserModel update(Long userId, RUpdateUserDto updateUserDto);
    List<RUserDto> listAll();
    RUserDetailsDto details(Long id);
}