package com.myfirst.cookbook.controller;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.dto.IngredientDtoShort;
import com.myfirst.cookbook.facade.IngredientFacade;
import com.myfirst.cookbook.form.IngredientForm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final IngredientFacade ingredientFacade;
    @GetMapping
    public ResponseEntity<List<IngredientDtoShort>> getAllIngredients() {
        List<IngredientDtoShort> allIngredients = ingredientFacade.getAll();
        return new ResponseEntity<>(allIngredients, HttpStatus.OK);
    }
    @GetMapping("/{ingId}")
    public ResponseEntity<IngredientDto> getIngredient(@PathVariable Long ingId) {
        IngredientDto ingredientDto = ingredientFacade.getById(ingId);
        return new ResponseEntity<>(ingredientDto, HttpStatus.OK);
    }
    @PostMapping("/new")
    public void postNewIngredient(@RequestBody IngredientForm ingredientForm){
        ingredientFacade.saveNewIngredient(ingredientForm);
    }
}
