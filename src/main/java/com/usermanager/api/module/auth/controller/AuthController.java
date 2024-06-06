package com.usermanager.api.module.auth.controller;

import com.usermanager.api.module.auth.dto.RAuthLoginDto;
import com.usermanager.api.module.auth.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid RAuthLoginDto authLoginDto) {
        return new ResponseEntity<>(this.authService.login(authLoginDto), HttpStatus.OK);
    }
}
