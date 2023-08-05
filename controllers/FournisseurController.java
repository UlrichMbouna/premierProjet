package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Fournisseur;
//@CrossOrigin(origins = "http://localhost:8080")
import com.example.demo.services.FournisseurService;


@RestController
@RequestMapping("/api")

public class FournisseurController {

	@Autowired
    private FournisseurService fournisseurService;
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

	
	@GetMapping("/fournisseurs")
	public List<Fournisseur> GetFournisseur(){
		return  fournisseurService.read();
	}

	@GetMapping("/fournisseurs/{id}")
	public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable("id") long id) {
		/*Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);

		if (fournisseurData.isPresent()) {
			return new ResponseEntity<>(fournisseurData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
		return fournisseurService.readSupplier(id);
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
	@GetMapping("/fournisseurs1")
	public ResponseEntity<Fournisseur> getFournisseurByParam(@RequestParam("id") long id) {
		/*Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);
			System.out.println("je suis dans le endpoint avec id = "+id);
		if (fournisseurData.isPresent()) {
			System.out.println("j ai vue le fournisseur avec id = " + id);
			return new ResponseEntity<>(fournisseurData.get(), HttpStatus.OK);
			
		} else {
			System.out.println("j n ai pas vue le fournisseur avec id = " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
		return fournisseurService.readSupplierId(id);
	}
	@PostMapping("/fournisseurs")
	public ResponseEntity<Void> AddFournisseur (@RequestBody Fournisseur fournisseur) {
		/*try {
			 fournisseurRepository.save(fournisseur);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return fournisseurService.addSupplier(fournisseur);
	}
	@PostMapping("/list_fournisseurs")
	public ResponseEntity<Void> AddListFournisseur (@RequestBody List<Fournisseur> fournisseurs) {
		/*try{ 
			for (Fournisseur fournisseur : fournisseurs) {
            	fournisseurRepository.save(fournisseur);
			}
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return fournisseurService.addSupplierList(fournisseurs)
;	}

	@PutMapping("fournisseurs/{id}")
	public ResponseEntity<Fournisseur> updatefournisseur(@PathVariable("id") long id, @RequestBody Fournisseur fournisseur) {
		/*Optional<Fournisseur> fournisseurData = fournisseurRepository.findById(id);

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
		}*/
		return fournisseurService.modifiedSupplier(id, fournisseur);
	}
    @DeleteMapping("/fournisseurs/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		/*try {
			fournisseurRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return fournisseurService.deleteSupplier(id);
	}

	@DeleteMapping("/fournisseurs")
	public ResponseEntity<HttpStatus> deleteAll() {
		/*try {
			fournisseurRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return fournisseurService.deleteAllSupplier();

	}

}
