package com.myfirst.cookbook.facade;

import com.myfirst.cookbook.entity.AuthenticationResponse;
import com.myfirst.cookbook.form.LoginForm;

public interface AuthorFacade {
    AuthenticationResponse login(LoginForm loginForm);
}
