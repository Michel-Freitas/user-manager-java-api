package com.usermanager.api.module.auth.service.impl;

import com.usermanager.api.module.auth.dto.RAuthLoginDto;
import com.usermanager.api.module.auth.model.UserAuthModel;
import com.usermanager.api.module.auth.service.IAuthService;
import com.usermanager.api.module.auth.service.TokenService;
import com.usermanager.api.module.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Override
    public Long authenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            UserAuthModel userAuthModel = (UserAuthModel) authentication.getPrincipal();
            UserModel a = userAuthModel.getUser();
            System.out.println(a.getId());
            return a.getId();
        } else {
            throw new RuntimeException();
        }
    }
}
