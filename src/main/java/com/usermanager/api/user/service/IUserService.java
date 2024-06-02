package com.usermanager.api.user.service;

import com.usermanager.api.user.dto.RCreateUserDto;
import com.usermanager.api.user.model.UserModel;

public interface IUserService {
    UserModel create(RCreateUserDto createUserDto);
}
