package com.example.demo.services;

import java.util.Optional;
import java.util.List;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.models.Fournisseur;
import com.example.demo.repositories.FournisseurRepository;
import lombok.Data;

@Data
@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

	public List<Fournisseur> lire(){
		return  fournisseurRepository.findAll();
	}

	//@GetMapping("/fournisseurs/{id}")
	public ResponseEntity<Fournisseur> LireUnfournisseur( long id) {
		Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);

		if (fournisseurData.isPresent()) {
			return new ResponseEntity<>(fournisseurData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/*@GetMapping("/fournisseurs/{id}/adrress/{id_address}")
	public ResponseEntity<Fournisseur> getAddressForFournisseur(@PathVariable("id") long id,@PathVariable("id_address")long id_address) {
		Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);

		if (fournisseurData.isPresent()) {
			return new ResponseEntity<>(fournisseurData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	//@GetMapping("/fournisseurs1")
	public ResponseEntity<Fournisseur> lireUnFournisseurId( long id) {
		Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);
			System.out.println("je suis dans le endpoint avec id = "+id);
		if (fournisseurData.isPresent()) {
			System.out.println("j ai vue le fournisseur avec id = " + id);
			return new ResponseEntity<>(fournisseurData.get(), HttpStatus.OK);
			
		} else {
			System.out.println("j n ai pas vue le fournisseur avec id = " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//@PostMapping("/fournisseurs")
	public ResponseEntity<Void> ajouteUnFournisseur ( Fournisseur fournisseur) {
		try {
			 fournisseurRepository.save(fournisseur);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//@PostMapping("/list_fournisseurs")
	public ResponseEntity<Void> AjouteUneListeFournisseur (List<Fournisseur> fournisseurs) {
		try{ 
			for (Fournisseur fournisseur : fournisseurs) {
            	fournisseurRepository.save(fournisseur);
			}
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//@PutMapping("fournisseurs/{id}")
	public ResponseEntity<Fournisseur> updatefournisseur( long id, Fournisseur fournisseur) {
		Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);

		if (fournisseurData.isPresent()) {
			Fournisseur _fournisseur = fournisseurData.get();
			_fournisseur.setNom(fournisseur.getNom());
			_fournisseur.setAddress(fournisseur.getAddress());
			_fournisseur.setEmail(fournisseur.getEmail());
			_fournisseur.setStatus(fournisseur.getStatus());
			_fournisseur.setTelephone(fournisseur.getTelephone());
			return new ResponseEntity<>(fournisseurRepository.save(_fournisseur), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    //@DeleteMapping("/fournisseurs/{id}")
	public ResponseEntity<HttpStatus> SupprimeFournisseur(long id) {
		try {
			fournisseurRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//@DeleteMapping("/fournisseurs")
	public ResponseEntity<HttpStatus> deleteAllfournisseurs() {
		try {
			fournisseurRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}