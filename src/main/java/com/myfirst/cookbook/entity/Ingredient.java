package com.myfirst.cookbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

@Data
@Entity
@Table(name="INGREDIENT")
public class Ingredient extends BasicEntity{
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private String price;
    @Column(name="PICTURE")
    private String picture;
}
