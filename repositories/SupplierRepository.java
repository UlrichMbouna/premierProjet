package com.example.demo.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
  List<Supplier> findAll();
  Optional<Supplier> findById (Long id_Supplier) ;
    void deleteById (Long id_Supplier) ;   
    // Supplier save( Supplier f);
  List<Supplier> findByNomContaining(String name);
}