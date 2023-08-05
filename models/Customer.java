package com.example.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // genere automatiquement les getters et setter ,tostring  
@Entity
@Table(name="customers")
@NoArgsConstructor // indique que la classe ne possede pas de constructeur sans arguments 
@AllArgsConstructor // genere les constructeurs avec tout les attributs
    

public class Customer {

        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id ;
    
        @Column
        private String nom;
    
        @Column
        private String address;
    }
    
