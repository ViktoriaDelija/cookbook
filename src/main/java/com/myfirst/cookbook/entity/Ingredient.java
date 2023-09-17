package com.myfirst.cookbook.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="INGREDIENT")
public class Ingredient extends BasicEntity{
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private Long price;
    @Column(name="TYPE")
    private String ingType;
    @Column(name="PICTURE")
    private String picture;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingredientsInRecipe")
    private List<Recipe> recipesOfIngredient = new ArrayList<>();
}
