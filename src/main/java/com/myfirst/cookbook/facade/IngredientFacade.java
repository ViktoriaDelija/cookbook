package com.myfirst.cookbook.facade;

import com.myfirst.cookbook.dto.IngredientDto;
import com.myfirst.cookbook.dto.IngredientDtoShort;

import java.util.List;

public interface IngredientFacade {
    List<IngredientDtoShort> getAll();

    IngredientDto getById(Long ingId);
}
