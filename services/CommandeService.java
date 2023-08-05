package com.example.demo.services;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.models.Commande;
import com.example.demo.models.Employe;
import com.example.demo.models.Produit;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.CommandeRepository;
import com.example.demo.repositories.EmployeRepository;

@Service




public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private ClientRepository clientRepository;

	public List<Commande> read(){
		return commandeRepository.findAll();
	}

    public ResponseEntity<Void> addCommand ( Commande commande,  long id_client ,long id_employe ) {

		Optional<Employe> optionalEmploye ;
		optionalEmploye = employeRepository.findById(id_employe);

        Optional<Client> optionalClient ;
		optionalClient = clientRepository.findById(id_client);


		if(optionalEmploye.isPresent() && optionalClient.isPresent() ){
				commande.setEmploye(optionalEmploye.get());
                commande.setClient(optionalClient.get());

		}
		
		try {
			 commandeRepository.save(commande);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("erreur =" + e.getMessage() );
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
}
