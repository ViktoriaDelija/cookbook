package com.myfirst.cookbook.service.impl;

import com.myfirst.cookbook.dto.RecipeDtoShort;
import com.myfirst.cookbook.entity.Recipe;
import com.myfirst.cookbook.repository.RecipeRepository;
import com.myfirst.cookbook.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getById(Long recId) {
        return recipeRepository
                .findById(recId)
                .orElseThrow(()-> new IllegalArgumentException("Recipe not found!"));
    }
}
