package com.myfirst.cookbook.facade.impl;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.dto.IngredientDtoShort;
import com.myfirst.cookbook.entity.Ingredient;
import com.myfirst.cookbook.facade.IngredientFacade;
import com.myfirst.cookbook.form.IngredientForm;
import com.myfirst.cookbook.mapper.IngredientMapper;
import com.myfirst.cookbook.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IngredientFacadeImpl implements IngredientFacade {

    private final IngredientService ingredientService;
    private final IngredientMapper ingredientMapper;
    @Override
    public List<IngredientDtoShort> getAll() {
        return ingredientService.getAll().stream().map(i -> {
            IngredientDtoShort ingredientDtoShort = new IngredientDtoShort();
            ingredientDtoShort.setName(i.getName());
            ingredientDtoShort.setID(i.getID());
            return ingredientDtoShort;
        }).collect(Collectors.toList());
    }

    @Override
    public IngredientDto getById(Long ingId) {
        Ingredient ingredient = ingredientService.getById(ingId);
        return ingredientMapper.mapIngredient(ingredient);
    }

    @Override
    public void saveNewIngredient(IngredientForm ingredientForm) {
        Ingredient ingredient = new Ingredient();
        ingredient = ingredientMapper.mapIngredientForm(ingredient, ingredientForm);
        ingredientService.saveIngredient(ingredient);
    }

    @Override
    public void deleteIngredient(Long ingId) {
        ingredientService.deleteIngredient(ingId);
    }

    @Override
    public IngredientDto editIngredient(Long ingId, IngredientForm ingredientForm) {
        Ingredient ingredient = ingredientService.getById(ingId);
        Ingredient ingredientEdited = ingredientMapper.mapIngredientForm(ingredient, ingredientForm);
        ingredientService.editIngredident(ingredientEdited);
        return ingredientMapper.mapIngredient(ingredientEdited);
    }

}