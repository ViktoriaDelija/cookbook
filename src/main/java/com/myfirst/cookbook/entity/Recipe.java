package com.myfirst.cookbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="RECIPE")
public class Recipe extends BasicEntity{
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="INGREDIENTS")
    private String ingredients; //change this to join table
    @Column(name="INSTRUCTIONS")
    private String instructions;
    @Column(name="AUTHOR_ID")
    private String author; //change this, this is going to be a join column
    @Column(name="PICTURE")
    private String picture;
}
