package com.example.demo.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Customer;


public interface CustomerRepository extends JpaRepository <Customer , Long> {

    Optional<Customer> findById(Long id_customer);

    //Optional<Customer> save(customer);
    
}
