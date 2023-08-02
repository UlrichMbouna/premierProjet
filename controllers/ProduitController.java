package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Fournisseur;
import com.example.demo.models.Produit;
import com.example.demo.repositories.FournisseurRepository;
import com.example.demo.repositories.ProduitRepository;
import com.example.demo.services.ProduitService;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ProduitController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("/produits")
	public List<Produit> FindAll(){
		return  produitService.lireToutLesProduits();
	}

	@GetMapping("/produits/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable("id") long id) {
		return produitService.lireUnProduit(id);
	}
	
	@GetMapping("/produits1")
	public ResponseEntity<Produit> getProduitByParam(@RequestParam("id") long id) {
		return produitService.LireProduitByParam(id);	
	}

	@PostMapping("fournisseurs/{id_fournisseur}/produits")
	public ResponseEntity<Void> AddProduit (@RequestBody Produit produit, @PathVariable("id_fournisseur") long id_fournisseur ) {
		return produitService.ajouteProduit(produit, id_fournisseur);
	}

	@PostMapping("/list_produits")
	public ResponseEntity<Void> AddListProduit (@RequestBody List<Produit> produits) {
		return produitService.AddListProduit(produits); 
	}

	@PutMapping("produits/{id}")
	public ResponseEntity<Produit> updateProduit(@PathVariable("id") long id, @RequestBody Produit produit) {
		return produitService.modifierProduit(id, produit);
	}

    @DeleteMapping("/produits/{id}")
	public ResponseEntity<HttpStatus> deleteProduit(@PathVariable("id") long id) {
		return produitService.supprimeProduit(id);
	}

	@DeleteMapping("/produits")
	public ResponseEntity<HttpStatus> deleteAllproduits() {
		return produitService.supprimeproduits();
	}

}
