package com.myfirst.cookbook.service;

import com.myfirst.cookbook.entity.Ingredient;

import java.util.Arrays;
import java.util.List;

public interface IngredientService {
    List<Ingredient> getAll();

    Ingredient getById(Long ingId);

    void saveIngredient(Ingredient ingredient);

    void deleteIngredient(Long ingId);

    Ingredient editIngredident(Ingredient ingredient);
}
