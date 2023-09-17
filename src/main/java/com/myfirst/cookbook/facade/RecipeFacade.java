package com.myfirst.cookbook.facade;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.dto.RecipeDtoShort;
import com.myfirst.cookbook.form.RecipeForm;

import java.util.List;

public interface RecipeFacade {
    List<RecipeDtoShort> getAll();

    RecipeDto getById(Long recId);

    void saveNewRecipe(RecipeForm recipeForm);

    void deleteRecipe(Long recId);
}
