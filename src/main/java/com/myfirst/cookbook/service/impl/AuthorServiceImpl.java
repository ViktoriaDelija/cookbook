package com.myfirst.cookbook.service.impl;

import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.repository.AuthorRepository;
import com.myfirst.cookbook.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public Author getByEmail(String email) {
        return authorRepository.findByEmail(email)
                .orElseThrow(()->new BeanDefinitionValidationException("User not found"));
    }
}
