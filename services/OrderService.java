package com.example.demo.services;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.models.Employe;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.EmployeRepository;

@Service




public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private CustomerRepository customerRepository;

	public List<Order> read(){
		return orderRepository.findAll();
	}

    public ResponseEntity<Void> addCommand ( Order order,  long id_Customer ,long id_employe ) {

		Optional<Employe> optionalEmploye ;
		optionalEmploye = employeRepository.findById(id_employe);

        Optional<Customer> optionalCustomer ;
		optionalCustomer = customerRepository.findById(id_Customer);


		if(optionalEmploye.isPresent() && optionalCustomer.isPresent() ){
				order.setCustomer(optionalCustomer.get());
				order.setEmploye(optionalEmploye.get());

		}
		
		try {
			 orderRepository.save(order);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("erreur =" + e.getMessage() );
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
}
