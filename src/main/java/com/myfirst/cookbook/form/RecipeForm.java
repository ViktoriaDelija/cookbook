package com.myfirst.cookbook.form;

import lombok.Data;

@Data
public class RecipeForm {
    private String name;
    private String description;
    private String instructions;
}
