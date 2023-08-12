package com.example.demo.services;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.models.Order;
import com.example.demo.models.OrderLine;
import com.example.demo.models.Product;
import com.example.demo.models.Employe;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.EmployeRepository;
import com.example.demo.repositories.ProductRepository;

@Service




public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public List<Order> read(){
		return orderRepository.findAll();
	}

    public ResponseEntity<Void> addCommand ( Order order,  
	long id_Customer ,
	long id_employe
	//Map<String, ArrayList<OrderLine>> orderLines
	)  {

		Optional<Employe> optionalEmploye ;
		optionalEmploye = employeRepository.findById(id_employe);

        Optional<Customer> optionalCustomer ;
		optionalCustomer = customerRepository.findById(id_Customer);

		//Optional<Product> optionalProduct ;
		//optionalProduct = productRepository.findById(id_product);
		


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
