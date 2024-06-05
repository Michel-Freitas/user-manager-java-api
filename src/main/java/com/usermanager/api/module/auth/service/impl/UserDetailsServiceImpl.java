package com.usermanager.api.module.auth.service.impl;

import com.usermanager.api.module.auth.model.UserAuthModel;
import com.usermanager.api.module.user.exception.UserNotFoundException;
import com.usermanager.api.module.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByCpf(username)
                .map(UserAuthModel::new)
                .orElseThrow(UserNotFoundException::new);
    }
}
