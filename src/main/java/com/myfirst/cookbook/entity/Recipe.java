package com.myfirst.cookbook.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="RECIPE")
public class Recipe extends BasicEntity{
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="INGREDIENTS")
    private String ingredients;
    @Column(name="INSTRUCTIONS")
    private String instructions;
    @OneToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;

    @Column(name="PICTURE")
    private String picture;

    @ManyToMany
    @JoinTable(name="LIST_INGREDIENTS",
            joinColumns = @JoinColumn(name="RECIPE_ID"),
            inverseJoinColumns =@JoinColumn(name="INGREDIENT_ID"))
    private List<Ingredient> ingredientsInRecipe = new ArrayList<>();

}
