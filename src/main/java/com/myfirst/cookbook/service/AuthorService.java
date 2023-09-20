package com.myfirst.cookbook.service;

import com.myfirst.cookbook.entity.Author;

public interface AuthorService {
    Author getByEmail(String email);
}
