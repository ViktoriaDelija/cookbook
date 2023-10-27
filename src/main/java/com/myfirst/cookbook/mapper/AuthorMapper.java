package com.myfirst.cookbook.mapper;

import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.form.SignupForm;

public interface AuthorMapper {
    Author mapSignupForm(SignupForm signupForm);
}
