package com.myfirst.cookbook.service.impl;

import com.myfirst.cookbook.entity.Ingredient;
import com.myfirst.cookbook.repository.IngredientRepository;
import com.myfirst.cookbook.service.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getById(Long ingId) {
        return ingredientRepository
                .findById(ingId)
                .orElseThrow(() -> new IllegalArgumentException("Ingredient not found!"));
    }

    @Override
    public void saveIngredient(Ingredient ingredient) {
        ingredient.setActivity(true);
        ingredient.setCreatedBy("Hardcoded");
        ingredient.setChangedBy("Hardcoded");
        ingredient.setDateOfChange(LocalDateTime.now());
        ingredient.setDateofCreation(LocalDateTime.now());
        ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Long ingId) {
        ingredientRepository.deleteById(ingId);
    }

    @Override
    public Ingredient editIngredident(Ingredient ingredient) {
        ingredient.setChangedBy("HardcodedEDITED");
        ingredient.setDateOfChange(LocalDateTime.now());
        return ingredientRepository.save(ingredient);
    }
}
