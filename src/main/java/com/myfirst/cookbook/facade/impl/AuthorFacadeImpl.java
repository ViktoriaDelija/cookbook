package com.myfirst.cookbook.facade.impl;

import com.myfirst.cookbook.entity.AuthenticationResponse;
import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.facade.AuthorFacade;
import com.myfirst.cookbook.form.LoginForm;
import com.myfirst.cookbook.security.UserDetailsCustom;
import com.myfirst.cookbook.security.service.JwtService;
import com.myfirst.cookbook.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthorFacadeImpl implements AuthorFacade {
    private final AuthenticationManager authenticationManager;
    private final AuthorService authorService;
    private final JwtService jwtService;
    @Override
    public AuthenticationResponse login(LoginForm loginForm) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.getEmail(),
                loginForm.getPassword()));
        Author author = authorService.getByEmail(loginForm.getEmail());
        UserDetailsCustom userDetails = new UserDetailsCustom(author);
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
