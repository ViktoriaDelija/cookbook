package com.myfirst.cookbook.facade;

import com.myfirst.cookbook.dto.RecipeDto;
import com.myfirst.cookbook.dto.RecipeDtoShort;

import java.util.List;

public interface RecipeFacade {
    List<RecipeDtoShort> getAll();

    RecipeDto getById(Long recId);
}
