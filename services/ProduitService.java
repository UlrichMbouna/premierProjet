package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.models.Fournisseur;
import com.example.demo.models.Produit;
import com.example.demo.repositories.FournisseurRepository;
import com.example.demo.repositories.ProduitRepository;

@Service   

public class ProduitService {
    
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;


    public List<Produit> lireToutLesProduits(){
		return  produitRepository.findAll();
	}

    public ResponseEntity<Produit> readProduct(long id) {
		Optional<Produit> produitData = produitRepository.findById(id);

		if (produitData.isPresent()) {
			return new ResponseEntity<>(produitData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<Produit> readProductByParam(long id) {
		Optional<Produit> produitData = produitRepository.findById(id);
			System.out.println("je suis dans le endpoint avec id = "+id);
		if (produitData.isPresent()) {
			System.out.println("j ai vue le produit avec id = " + id);
			return new ResponseEntity<>(produitData.get(), HttpStatus.OK);
			
		} else {
			System.out.println("j n ai pas vue le produit avec id = " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

	public ResponseEntity<Void> addProduct ( Produit produit,  long id_fournisseur ) {

		Optional<Fournisseur> optionalfournisseur ;
		optionalfournisseur = fournisseurRepository.findById(id_fournisseur);
		if(optionalfournisseur.isPresent()){
				produit.setFournisseur(optionalfournisseur.get());
		}
		
		try {
			 produitRepository.save(produit );
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("erreur =" + e.getMessage() );
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ResponseEntity<Void> AddListProduct ( List<Produit> produits) {
		try{ 
			for (Produit produit : produits) {
            	produitRepository.save(produit);
			}
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Produit> modifiedProduct(long id,  Produit produit) {
		Optional<Produit> produitData = produitRepository.findById(id);

		if (produitData.isPresent()) {
			Produit _produit = produitData.get();
			_produit.setNom(produit.getNom());
			_produit.setImage(produit.getImage());
			_produit.setMarque(produit.getMarque());
			_produit.setDescription(produit.getDescription());
			_produit.setPrix(produit.getPrix());
			return new ResponseEntity<>(produitRepository.save(_produit), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<HttpStatus> deleteProduct( long id) {
		try {
			produitRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deleteproducts() {
		try {
			produitRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}





}
