package com.myfirst.cookbook.mapper.impl;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.entity.Ingredient;
import com.myfirst.cookbook.mapper.IngredientMapper;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapperImpl implements IngredientMapper {
    @Override
    public IngredientDto mapIngredient(Ingredient ingredient) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setDescription(ingredient.getDescription());
        ingredientDto.setPrice(ingredient.getPrice());
        ingredientDto.setIngType(ingredient.getIngType());
        return ingredientDto;
    }
}
