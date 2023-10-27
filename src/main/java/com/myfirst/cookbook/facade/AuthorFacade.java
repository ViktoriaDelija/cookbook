package com.myfirst.cookbook.facade;

import com.myfirst.cookbook.dto.AuthorDtoShort;
import com.myfirst.cookbook.entity.AuthenticationResponse;
import com.myfirst.cookbook.form.LoginForm;
import com.myfirst.cookbook.form.SignupForm;

import java.util.List;

public interface AuthorFacade {
    AuthenticationResponse login(LoginForm loginForm);
    List<AuthorDtoShort> getAll();
    void signup(SignupForm signupForm);
}
