package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="categories")


public class Categorie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private long id ;

    @Column
    private String nom;


}
