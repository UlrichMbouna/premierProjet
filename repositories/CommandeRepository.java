package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Commande;

public interface CommandeRepository extends JpaRepository <Commande , Long >{

    
}
