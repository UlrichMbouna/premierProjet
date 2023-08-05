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

import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

@RestController
@RequestMapping("/api")

public class ClientController {

    @Autowired
    private ClientService clientService;

        @GetMapping("/client")
    public List<Client> getAllclient(){
            return clientService.read();
    };
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getConstomer(@PathVariable long id){
        return clientService.readCustomer(id);
    };
    @PostMapping("/client")
    public ResponseEntity<Void> saveclient(@RequestBody Client client){
        return clientService.addCustomer(client);
    };

    @PutMapping("/client")
    public ResponseEntity<Client> updateclient(@RequestBody Client client, @PathVariable long id){
        return clientService.modifiedCustomer(id, client);
    };



    
}
