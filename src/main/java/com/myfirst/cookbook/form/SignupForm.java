package com.myfirst.cookbook.form;

import lombok.Data;

@Data
public class SignupForm {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
