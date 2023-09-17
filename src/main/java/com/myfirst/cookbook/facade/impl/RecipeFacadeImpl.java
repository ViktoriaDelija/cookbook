package com.myfirst.cookbook.facade.impl;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.dto.RecipeDtoShort;
import com.myfirst.cookbook.entity.Recipe;
import com.myfirst.cookbook.facade.RecipeFacade;
import com.myfirst.cookbook.form.RecipeForm;
import com.myfirst.cookbook.mapper.RecipeMapper;
import com.myfirst.cookbook.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RecipeFacadeImpl implements RecipeFacade {
    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    @Override
    public List<RecipeDtoShort> getAll() {
        return recipeService.getAll().stream().map(r-> {
            RecipeDtoShort recipeDtoShort = new RecipeDtoShort();
            recipeDtoShort.setName(r.getName());
            recipeDtoShort.setID(r.getID());
            return recipeDtoShort;
        }).collect(Collectors.toList());
    }

    @Override
    public RecipeDto getById(Long recId) {
        Recipe recipe = recipeService.getById(recId);
        return recipeMapper.mapRecipe(recipe);
    }

    @Override
    public void saveNewRecipe(RecipeForm recipeForm) {
        Recipe recipe = new Recipe();
        recipe = recipeMapper.mapRecipeForm(recipe, recipeForm);
        recipeService.saveRecipe(recipe);
    }

    @Override
    public void deleteRecipe(Long recId) {
        recipeService.deleteRecipe(recId);
    }
}
