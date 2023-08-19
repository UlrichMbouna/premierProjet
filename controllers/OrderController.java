package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.OrderForCustomerDTO;
import com.example.demo.DTOs.OrderForEmployeDTO;
import com.example.demo.mappers.Mapper;
import com.example.demo.models.Order;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("/api")

public class OrderController {

        @Autowired
        private OrderService orderService ;

        @Autowired
        private Mapper mapper;


    @GetMapping("/Order")
    public List<OrderForCustomerDTO> findAllOrders(){
        return orderService.read()
                            .stream()
                            .map(mapper::toDto)
                            .collect(Collectors.toList());
    }

    @GetMapping("/OrderEmploye")
    public List<OrderForEmployeDTO> findAllOrder(){
        return orderService.read()
                            .stream()
                            .map(mapper::toDto1)
                            .collect(Collectors.toList());
    }

    @PostMapping("/Order/{id_client}/{id_employe}")
    public ResponseEntity<Void> postOrder ( 
     @RequestBody Order Order,
     @PathVariable("id_client") long id_client ,
     @PathVariable("id_employe") long id_employe 
     //@RequestBody Map <String, ArrayList<OrderLine> > orderLines
     ){
       // orderLines.get("orderLine");
        return orderService.addCommand(Order, id_client, id_employe);
     }
    @DeleteMapping("/Order")
	  public ResponseEntity<HttpStatus> deleteAllOrder() {
		  return orderService.deleteOrder();
	  }
    
}
