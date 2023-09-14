package com.myfirst.cookbook.mapper;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.entity.Ingredient;
import com.myfirst.cookbook.form.IngredientForm;

public interface IngredientMapper {
    IngredientDto mapIngredient(Ingredient ingredient);

    Ingredient mapIngredientForm(Ingredient ingredient, IngredientForm ingredientForm);
}
