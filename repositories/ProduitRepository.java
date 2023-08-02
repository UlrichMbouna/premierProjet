package com.example.demo.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
  List<Produit> findAll();
  Optional<Produit> findById (Long id_Produit) ;
    void deleteById (Long id_Produit) ;   
 List<Produit> findByNomContaining(String nom);
}