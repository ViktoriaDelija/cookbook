package com.myfirst.cookbook.mapper.impl;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.entity.Recipe;
import com.myfirst.cookbook.mapper.RecipeMapper;
import org.springframework.stereotype.Component;

@Component
public class RecipeMapperImpl implements RecipeMapper {
    @Override
    public RecipeDto mapRecipe(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setInstructions(recipe.getInstructions());
        recipeDto.setID(recipe.getID());
        return recipeDto;
    }
}
