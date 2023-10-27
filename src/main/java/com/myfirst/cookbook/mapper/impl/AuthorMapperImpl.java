package com.myfirst.cookbook.mapper.impl;

import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.form.SignupForm;
import com.myfirst.cookbook.mapper.AuthorMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author mapSignupForm(SignupForm signupForm) {
        Author author = new Author();
        author.setFirstName(signupForm.getFirstname());
        author.setLastName(signupForm.getLastname());
        author.setEmail(signupForm.getEmail());
        author.setPassword(new BCryptPasswordEncoder()
                .encode(signupForm
                        .getPassword()));
        return author;
    }
}
