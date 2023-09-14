package com.myfirst.cookbook.facade;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.dto.IngredientDtoShort;
import com.myfirst.cookbook.entity.Ingredient;
import com.myfirst.cookbook.form.IngredientForm;

import java.util.List;

public interface IngredientFacade {
    List<IngredientDtoShort> getAll();

    IngredientDto getById(Long ingId);

    void saveNewIngredient(IngredientForm ingredientForm);
}
