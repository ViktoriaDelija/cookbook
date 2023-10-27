package com.myfirst.cookbook.service;

import com.myfirst.cookbook.entity.Author;

import java.util.Arrays;
import java.util.List;

public interface AuthorService {
    Author getByEmail(String email);
    List<Author> getAll();
    void saveUser(Author author);
}
