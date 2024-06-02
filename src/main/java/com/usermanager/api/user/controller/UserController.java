package com.usermanager.api.user.controller;

import com.usermanager.api.user.dto.RCreateUserDto;
import com.usermanager.api.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody RCreateUserDto createUserDto) {
        this.userService.create(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
