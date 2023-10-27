package com.myfirst.cookbook.service.impl;

import com.myfirst.cookbook.entity.Recipe;
import com.myfirst.cookbook.repository.RecipeRepository;
import com.myfirst.cookbook.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public void saveRecipe(Recipe recipe) {
        recipe.setActivity(true);
        recipe.setCreatedBy(recipe.getAuthor().getFirstName()+" "+recipe.getAuthor().getLastName());
        recipe.setChangedBy(recipe.getAuthor().getFirstName()+" "+recipe.getAuthor().getLastName());
        recipe.setDateOfChange(LocalDateTime.now());
        recipe.setDateofCreation(LocalDateTime.now());
        recipeRepository.save(recipe);

    }

    @Override
    public void deleteRecipe(Long recId) {
        recipeRepository.deleteById(recId);
    }

    @Override
    public Recipe editRecipe(Recipe recipe) {
        recipe.setChangedBy("HardcodedEdited");
        recipe.setDateOfChange(LocalDateTime.now());
        return recipeRepository.save(recipe);
    }
}
