package com.usermanager.api.module.auth.model;

import com.usermanager.api.module.user.enums.EUserRole;
import com.usermanager.api.module.user.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class UserAuthModel implements  UserDetails{
    private final UserModel user;

    public UserAuthModel(UserModel user) {
        this.user = user;
    }

    public UserModel getUser() {
        return this.user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
        var roleCommon = new SimpleGrantedAuthority("ROLE_COMMON");

        return this.user.getRole() == EUserRole.ADMIN ? List.of(roleAdmin, roleCommon) : List.of(roleCommon);
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getCpf();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
