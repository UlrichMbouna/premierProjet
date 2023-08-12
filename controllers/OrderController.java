package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Order;
import com.example.demo.models.OrderLine;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("/api")

public class OrderController {

        @Autowired
        private OrderService OrderService ;


    @GetMapping("/Order")
    public List<Order> findAllOrders(){
        return OrderService.read();
    }

    @PostMapping("/Order/{id_client}/{id_employe}")
    public ResponseEntity<Void> postOrder ( 
     @RequestBody Order Order,
     @PathVariable("id_client") long id_client ,
     @PathVariable("id_employe") long id_employe 
     //@RequestBody Map <String, ArrayList<OrderLine> > orderLines
     ){
       // orderLines.get("orderLine");
        return OrderService.addCommand(Order, id_client, id_employe);
     }

    
}
