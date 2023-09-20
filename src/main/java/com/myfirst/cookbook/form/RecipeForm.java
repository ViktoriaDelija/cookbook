package com.myfirst.cookbook.form;

import lombok.Data;

import java.util.List;

@Data
public class RecipeForm {
    private String name;
    private String description;
    private String instructions;
    private List<Long> ingredientIds;
}
