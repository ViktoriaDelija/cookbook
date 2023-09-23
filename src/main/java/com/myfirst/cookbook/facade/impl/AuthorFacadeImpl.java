package com.myfirst.cookbook.facade.impl;

import com.myfirst.cookbook.dto.AuthorDtoShort;
import com.myfirst.cookbook.dto.IngredientDtoShort;
import com.myfirst.cookbook.entity.AuthenticationResponse;
import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.facade.AuthorFacade;
import com.myfirst.cookbook.form.LoginForm;
import com.myfirst.cookbook.form.SignupForm;
import com.myfirst.cookbook.mapper.AuthorMapper;
import com.myfirst.cookbook.security.UserDetailsCustom;
import com.myfirst.cookbook.security.service.JwtService;
import com.myfirst.cookbook.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AuthorFacadeImpl implements AuthorFacade {
    private final AuthenticationManager authenticationManager;
    private final AuthorService authorService;
    private final JwtService jwtService;
    private final AuthorMapper authorMapper;
    @Override
    public AuthenticationResponse login(LoginForm loginForm) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.getEmail(),
                loginForm.getPassword()));
        Author author = authorService.getByEmail(loginForm.getEmail());
        UserDetailsCustom userDetails = new UserDetailsCustom(author);
        String jwtToken = jwtService.generateToken(userDetails);
        String userRole = userDetails.getAuthorities().toString();
        return AuthenticationResponse.builder().token(jwtToken).roles(userRole).build();
    }

    @Override
    public List<AuthorDtoShort> getAll() {
        return authorService.getAll().stream().map(a -> {
            AuthorDtoShort authorDtoShort = new AuthorDtoShort();
            authorDtoShort.setFirstName(a.getFirstName());
            authorDtoShort.setLastName(a.getLastName());
            authorDtoShort.setEmail(a.getEmail());
            authorDtoShort.setAuthorRole(a.getAuthorRole());
            return authorDtoShort;
        }).collect(Collectors.toList());
    }

    @Override
    public void signup(SignupForm signupForm) {
        authorService.saveUser(authorMapper.mapSignupForm(signupForm));
    }
}

