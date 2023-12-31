package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employe;
import com.example.demo.services.EmployeService;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")

public class EmployeController {

    @Autowired //  creer une instance d objet dans une classe
    private EmployeService employeService;

    @GetMapping("/employe")
    public List<Employe> getAllEmploye(){
            return employeService.read();
    };
    @GetMapping("/employe/{id}")
    public ResponseEntity<Employe> GetEmploye(@PathVariable long id){
        return employeService.readEmployee(id);
    };
    @PostMapping("/employe")
    public ResponseEntity<Void> saveEmploye(@RequestBody Employe employe){
        return employeService.addEmployee(employe);
    };

    @PutMapping("/employe")
    public ResponseEntity<Employe> updateEmploye(@RequestBody Employe employe, @PathVariable long id){
        return employeService.modifiedEmployee(id, employe);
    };

}
