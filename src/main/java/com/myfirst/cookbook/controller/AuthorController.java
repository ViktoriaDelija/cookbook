package com.myfirst.cookbook.controller;

import com.myfirst.cookbook.entity.AuthenticationResponse;
import com.myfirst.cookbook.facade.AuthorFacade;
import com.myfirst.cookbook.form.LoginForm;
import com.myfirst.cookbook.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AuthorController {
    private final AuthorFacade authorFacade;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginForm loginForm){
        return ResponseEntity.ok(authorFacade.login(loginForm));
    }
}
