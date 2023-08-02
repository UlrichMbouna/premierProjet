package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;
@Service



public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> lire (){

            return clientRepository.findAll();
        };

        public ResponseEntity<Client> LireUnclient(long id ){
            Optional<Client> clientData = clientRepository.findById(id);

		if (clientData.isPresent()) {
			return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

        };

        public ResponseEntity<Void> ajouteUnclient ( Client client) {
		try {
			 clientRepository.save(client);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    };

        public ResponseEntity<Client> modificlient( long id, Client client) {
		Optional<Client> clientData = clientRepository.findById(id);

		if (clientData.isPresent()) {
			Client _client = clientData.get();
			_client.setNom(client.getNom());
			_client.setAdress(client.getAdress());
			return new ResponseEntity<>(clientRepository.save(_client), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
            

    


}}
