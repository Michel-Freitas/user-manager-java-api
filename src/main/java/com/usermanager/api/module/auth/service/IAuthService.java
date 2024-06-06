package com.usermanager.api.module.auth.service;

import com.usermanager.api.module.auth.dto.RAuthLoginDto;

public interface IAuthService {
    String login(RAuthLoginDto authLoginDto);
    Long authenticatedUserId();
}
