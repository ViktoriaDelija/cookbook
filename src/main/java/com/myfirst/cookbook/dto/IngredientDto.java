package com.myfirst.cookbook.dto;

import lombok.Data;

@Data
public class IngredientDto extends IngredientDtoShort{
    private String description;
    private String price;
    private String ingType;
    private String picture;
}
