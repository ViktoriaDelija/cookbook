package com.myfirst.cookbook.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "ACTIVITY")
    private boolean activity;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "DATE_OF_CREATION")
    private LocalDateTime dateofCreation;
    @Column(name = "CHANGED_BY")
    private String changedBy;
    @Column(name = "DATE_OF_CHANGE")
    private LocalDateTime dateOfChange;
}
