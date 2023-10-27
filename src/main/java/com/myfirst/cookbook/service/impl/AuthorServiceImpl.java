package com.myfirst.cookbook.service.impl;

import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.repository.AuthorRepository;
import com.myfirst.cookbook.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Override
    public Author getByEmail(String email) {
        return authorRepository.findByEmail(email)
                .orElseThrow(()->new BeanDefinitionValidationException("User not found"));
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void saveUser(Author author) {
        author.setAuthorRole("USER");
        author.setActivity(true);
        author.setCreatedBy(author.getFirstName()+" "+author.getLastName());
        author.setDateofCreation(LocalDateTime.now());
        author.setChangedBy(author.getFirstName()+" "+author.getLastName());
        author.setDateOfChange(LocalDateTime.now());
        authorRepository.save(author);
    }
}
