package com.usermanager.api.module.user.service;

import com.usermanager.api.module.user.dto.RUpdateUserDto;
import com.usermanager.api.module.user.model.UserModel;
import com.usermanager.api.module.user.dto.RCreateUserDto;

public interface IUserService {
    UserModel create(RCreateUserDto createUserDto);
    UserModel update(Long userId, RUpdateUserDto updateUserDto);
}