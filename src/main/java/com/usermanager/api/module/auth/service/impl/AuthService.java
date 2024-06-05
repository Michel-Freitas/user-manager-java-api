package com.usermanager.api.module.auth.service.impl;

import com.usermanager.api.module.auth.dto.RAuthLoginDto;
import com.usermanager.api.module.auth.service.IAuthService;
import com.usermanager.api.module.auth.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public String login(RAuthLoginDto authLoginDto) {
        var usernamePasseword = new UsernamePasswordAuthenticationToken(authLoginDto.cpf(), authLoginDto.password());
        var auth = this.authenticationManager.authenticate(usernamePasseword);

        return this.tokenService.generateToken(auth.getName(), auth.getAuthorities());
    }
}
