package com.usermanager.api.module.user.controller;

import com.usermanager.api.module.user.dto.RCreateUserDto;
import com.usermanager.api.module.user.dto.RUpdateUserDto;
import com.usermanager.api.module.user.dto.RUserDetailsDto;
import com.usermanager.api.module.user.dto.RUserDto;
import com.usermanager.api.module.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody RUpdateUserDto updateUserDto) {
        this.userService.update(id, updateUserDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RUserDto>> listAll() {
        return new ResponseEntity<>(this.userService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RUserDetailsDto> details(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.details(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
