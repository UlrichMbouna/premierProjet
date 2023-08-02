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

import com.example.demo.models.Commande;
import com.example.demo.services.CommandeService;

@RestController
@RequestMapping("/api")

public class CommandeController {

        @Autowired
        private CommandeService commandeService ;


    @GetMapping("/commande")
    public List<Commande> findAllCommandes(){
        return commandeService.lire();
    }

    @PostMapping("/commande/{id_client}/{id_employe}")
    public ResponseEntity<Void> postCommande ( @RequestBody Commande commande, @PathVariable("id_client") long id_client ,@PathVariable("id_employe") long id_employe ){

        return commandeService.ajouteCommande(commande, id_client, id_employe);
    }

    
}
