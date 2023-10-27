package com.myfirst.cookbook.dto;

import lombok.Data;

@Data
public class AuthorDtoShort {
    private String firstName;
    private String lastName;
    private String email;
    private String authorRole;
}
