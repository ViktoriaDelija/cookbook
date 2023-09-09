package com.myfirst.cookbook.facade.impl;

import com.myfirst.cookbook.dto.IngredientDtoShort;
import com.myfirst.cookbook.facade.IngredientFacade;
import com.myfirst.cookbook.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class IngredientFacadeImpl implements IngredientFacade {
    private final IngredientService ingredientService;
    @Override
    public List<IngredientDtoShort> getAll() {
        return ingredientService.getAll().stream().map(i -> {
            IngredientDtoShort ingredientDtoShort = new IngredientDtoShort();
            ingredientDtoShort.setName(i.getName());
            ingredientDtoShort.setID(i.getID());
            return ingredientDtoShort;
        }).collect(Collectors.toList());
    }
}