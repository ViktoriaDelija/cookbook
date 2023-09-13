package com.myfirst.cookbook.controller;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.dto.IngredientDtoShort;
import com.myfirst.cookbook.facade.IngredientFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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
}
