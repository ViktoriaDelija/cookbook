package com.myfirst.cookbook.controller;

import com.myfirst.cookbook.dto.AuthorDtoShort;
import com.myfirst.cookbook.entity.AuthenticationResponse;
import com.myfirst.cookbook.entity.Author;
import com.myfirst.cookbook.facade.AuthorFacade;
import com.myfirst.cookbook.form.LoginForm;
import com.myfirst.cookbook.form.SignupForm;
import com.myfirst.cookbook.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorDtoShort>> allAuthors(){
        List<AuthorDtoShort> allAuthors = authorFacade.getAll();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupForm signupForm){
        authorFacade.signup(signupForm);
    }

}
