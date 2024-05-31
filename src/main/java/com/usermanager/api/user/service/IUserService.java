package com.usermanager.api.user.service;

import com.usermanager.api.user.dto.RCreateUserDto;

public interface IUserService {
    void create(RCreateUserDto createUserDto);
}
