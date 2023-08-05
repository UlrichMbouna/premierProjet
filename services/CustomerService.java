package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
@Service



public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> read (){

            return customerRepository.findAll();
        };

        public ResponseEntity<Customer> readCustomer(long id ){
            Optional<Customer> CustomerData = customerRepository.findById(id);

		if (CustomerData.isPresent()) {
			return new ResponseEntity<>(CustomerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

        };

        public ResponseEntity<Void> addCustomer ( Customer customer) {
		try {
			 customerRepository.save(customer);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    };

        public ResponseEntity<Customer> modifiedCustomer( long id, Customer customer) {
		Optional<Customer> CustomerData = customerRepository.findById(id);

		if (CustomerData.isPresent()) {
			Customer _customer= CustomerData.get();
			_customer.setNom(customer.getNom());
			_customer.setAddress(customer.getAddress());
			return new ResponseEntity<>( customerRepository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
            

    


}}
