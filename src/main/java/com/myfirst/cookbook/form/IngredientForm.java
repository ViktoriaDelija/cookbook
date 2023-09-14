package com.myfirst.cookbook.form;

import lombok.Data;

@Data
public class IngredientForm {
    private String name;
    private String description;
    private String ingType;
    private Long price;
}
