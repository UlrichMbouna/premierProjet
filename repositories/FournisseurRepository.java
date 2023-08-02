package com.example.demo.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
  List<Fournisseur> findAll();
  Optional<Fournisseur> findById (Long id_fournisseur) ;
    void deleteById (Long id_fournisseur) ;   
    // Fournisseur save( Fournisseur f);
  List<Fournisseur> findByNomContaining(String nom);
}