package com.myfirst.cookbook.mapper;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.entity.Recipe;

public interface RecipeMapper {
    RecipeDto mapRecipe(Recipe recipe);
}
