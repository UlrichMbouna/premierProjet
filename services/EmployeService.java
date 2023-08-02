package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.Employe;
import com.example.demo.repositories.EmployeRepository;

@Service


public class EmployeService {

	@Autowired
    private EmployeRepository employeRepository;

        public List<Employe> lire (){

            return employeRepository.findAll();
        };

        public ResponseEntity<Employe> LireUnEmploye(long id ){
            Optional<Employe> employeData = employeRepository.findById(id);

		if (employeData.isPresent()) {
			return new ResponseEntity<>(employeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

        };

        public ResponseEntity<Void> ajouteUnemploye ( Employe employe) {
		try {
			 employeRepository.save(employe);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    };

        public ResponseEntity<Employe> modifiemploye( long id, Employe employe) {
		Optional<Employe> employeData = employeRepository.findById(id);

		if (employeData.isPresent()) {
			Employe _employe = employeData.get();
			_employe.setNom(employe.getNom());
			_employe.setPoste(employe.getPoste());
			_employe.setEmail(employe.getEmail());
			_employe.setSalaire(employe.getSalaire());
			return new ResponseEntity<>(employeRepository.save(_employe), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	    };


    
}