package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employe;

public interface EmployeRepository extends JpaRepository <Employe , Long  > {

    Optional<Employe> findById(long id_employe);
    
}
