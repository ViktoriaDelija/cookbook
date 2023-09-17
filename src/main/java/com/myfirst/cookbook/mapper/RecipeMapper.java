package com.myfirst.cookbook.mapper;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.entity.Recipe;
import com.myfirst.cookbook.form.RecipeForm;

public interface RecipeMapper {
    RecipeDto mapRecipe(Recipe recipe);

    Recipe mapRecipeForm(Recipe recipe, RecipeForm recipeForm);
}
