package com.myfirst.cookbook.security;

import com.myfirst.cookbook.entity.Author;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsCustom implements UserDetails {
    private String email;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;

    public UserDetailsCustom(Author author){
        this.email = author.getEmail();
        this.password= author.getPassword();
        this.grantedAuthorities= initAuthorities(author.getAuthorRole());
    }
    private List<GrantedAuthority> initAuthorities(String authorRole){
        return Arrays.stream(authorRole.split(","))
                .map(user -> new SimpleGrantedAuthority("ROLE_"+authorRole.trim().toUpperCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
