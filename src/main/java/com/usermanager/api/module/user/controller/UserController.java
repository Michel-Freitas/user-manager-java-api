package com.usermanager.api.module.user.controller;

import com.usermanager.api.module.user.dto.RCreateUserDto;
import com.usermanager.api.module.user.dto.RUpdateUserDto;
import com.usermanager.api.module.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public ResponseEntity<String> update(@Valid @RequestBody RUpdateUserDto updateUserDto) {
        this.userService.update(updateUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
