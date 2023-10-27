package com.myfirst.cookbook.security.service;

import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.repository.AuthorRepository;
import com.myfirst.cookbook.security.UserDetailsCustom;
import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    private final AuthorRepository authorRepository;

    public UserDetailsCustomService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Author author = authorRepository
                .findByEmail(email)
                .orElseThrow(() -> new BeanDefinitionValidationException("Ne postoji username: " + email));
        return new UserDetailsCustom(author);
    }
}
