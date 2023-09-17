package com.myfirst.cookbook.service;

import com.myfirst.cookbook.dto.RecipeDtoShort;
import com.myfirst.cookbook.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAll();

    Recipe getById(Long recId);

    void saveRecipe(Recipe recipe);

    void deleteRecipe(Long recId);
}
