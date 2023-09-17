package com.myfirst.cookbook.controller;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.dto.RecipeDtoShort;
import com.myfirst.cookbook.facade.RecipeFacade;
import com.myfirst.cookbook.form.RecipeForm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeFacade recipeFacade;

    @GetMapping
    public ResponseEntity<List<RecipeDtoShort>> getAllRecipes() {
        List<RecipeDtoShort> allRecipes = recipeFacade.getAll();
        return new ResponseEntity<>(allRecipes, HttpStatus.OK);
    }
    @GetMapping("/{recId}")
    public ResponseEntity<RecipeDto> getRecipe(@PathVariable Long recId){
        RecipeDto recipeDto = recipeFacade.getById(recId);
        return new ResponseEntity<>(recipeDto, HttpStatus.OK);
    }
    @PostMapping("/new")
    public void postNewRecipe(@RequestBody RecipeForm recipeForm){
        recipeFacade.saveNewRecipe(recipeForm);
    }
    @DeleteMapping("/delete/{recId}")
    public void deleteRecipe(@PathVariable Long recId){
        recipeFacade.deleteRecipe(recId);
    }
}
