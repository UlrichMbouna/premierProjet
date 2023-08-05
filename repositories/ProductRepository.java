package com.example.demo.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findAll();
  Optional<Product> findById (Long id_Product) ;
    void deleteById (Long id_Product) ;   
 //List<Product> findByNameContaining(String name);
}