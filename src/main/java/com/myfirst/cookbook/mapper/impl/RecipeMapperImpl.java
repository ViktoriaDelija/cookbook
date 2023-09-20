package com.myfirst.cookbook.mapper.impl;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.entity.Ingredient;
import com.myfirst.cookbook.entity.Recipe;
import com.myfirst.cookbook.form.RecipeForm;
import com.myfirst.cookbook.mapper.RecipeMapper;
import com.myfirst.cookbook.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class RecipeMapperImpl implements RecipeMapper {
    private final IngredientRepository ingredientRepository;

    @Override
    public RecipeDto mapRecipe(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setName(recipe.getName());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setInstructions(recipe.getInstructions());
        recipeDto.setID(recipe.getID());
        recipeDto.setIngredientsInRecipe(recipe.getIngredientsInRecipe());
        return recipeDto;
    }

    @Override
    public Recipe mapRecipeForm(Recipe recipe, RecipeForm recipeForm) {
        recipe.setName(recipeForm.getName());
        recipe.setDescription(recipeForm.getDescription());
        recipe.setInstructions(recipeForm.getInstructions());
        List<Long> ingredients = recipeForm.getIngredientIds();
        if (ingredients != null) {
            for (Long id : ingredients) {
                Ingredient ingredient = ingredientRepository
                        .findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Ingredient with this ID does not exist"));
                recipe.getIngredientsInRecipe().add(ingredient);
            }
        }
        return recipe;
    }
}
