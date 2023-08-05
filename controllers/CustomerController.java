package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/api")

public class CustomerController {

    @Autowired
    private CustomerService CustomerService;

        @GetMapping("/Customer")
    public List<Customer> getAllCustomer(){
            return CustomerService.read();
    };
    @GetMapping("/Customer/{id}")
    public ResponseEntity<Customer> getConstomer(@PathVariable long id){
        return CustomerService.readCustomer(id);
    };
    @PostMapping("/Customer")
    public ResponseEntity<Void> saveCustomer(@RequestBody Customer Customer){
        return CustomerService.addCustomer(Customer);
    };

    @PutMapping("/Customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer Customer, @PathVariable long id){
        return CustomerService.modifiedCustomer(id, Customer);
    };



    
}
