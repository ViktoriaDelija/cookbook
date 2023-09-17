package com.myfirst.cookbook.dto;

import lombok.Data;

@Data
public class RecipeDto extends RecipeDtoShort{
    private String description;
    private String instructions;
    //private String ingredients

}
