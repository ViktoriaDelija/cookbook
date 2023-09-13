package com.myfirst.cookbook.mapper;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.entity.Ingredient;

public interface IngredientMapper {
    IngredientDto mapIngredient(Ingredient ingredient);
}
