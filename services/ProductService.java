package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.models.Supplier;
import com.example.demo.models.Product;
import com.example.demo.repositories.SupplierRepository;
import com.example.demo.repositories.ProductRepository;

@Service   

public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;


    public List<Product> readAllProducts(){
		return  productRepository.findAll();
	}

    public ResponseEntity<Product> readProduct(long id) {
		Optional<Product> ProductData = productRepository.findById(id);

		if (ProductData.isPresent()) {
			return new ResponseEntity<>(ProductData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<Product> readProductByParam(long id) {
		Optional<Product> ProductData = productRepository.findById(id);
			System.out.println("je suis dans le endpoint avec id = "+id);
		if (ProductData.isPresent()) {
			System.out.println("j ai vue le Product avec id = " + id);
			return new ResponseEntity<>(ProductData.get(), HttpStatus.OK);
			
		} else {
			System.out.println("j n ai pas vue le Product avec id = " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

	public ResponseEntity<Void> addProduct ( Product Product,  long id_Supplier ) {

		Optional<Supplier> optionalSupplier ;
		optionalSupplier = supplierRepository.findById(id_Supplier);
		if(optionalSupplier.isPresent()){
				Product.setSupplier(optionalSupplier.get());
		}
		
		try {
			 productRepository.save(Product );
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("erreur =" + e.getMessage() );
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public ResponseEntity<Void> AddListProduct ( List<Product> Products) {
		try{ 
			for (Product Product : Products) {
            	productRepository.save(Product);
			}
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Product> modifiedProduct(long id,  Product product) {
		Optional<Product> ProductData = productRepository.findById(id);

		if (ProductData.isPresent()) {
			Product _product = ProductData.get();
			_product.setNom(product.getNom());
			_product.setPicture(product.getPicture());
			_product.setMark(product.getMark());
			_product.setDescription(product.getDescription());
			_product.setPrice(product.getPrice());
			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<HttpStatus> deleteProduct( long id) {
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deleteproducts() {
		try {
			productRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}





}
