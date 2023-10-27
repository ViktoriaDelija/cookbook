package com.myfirst.cookbook.dto;

import com.myfirst.cookbook.entity.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDto extends RecipeDtoShort{
    private String description;
    private String instructions;
    private List<Ingredient> ingredientsInRecipe;
}
