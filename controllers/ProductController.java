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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService ProductService;

	@GetMapping("/Products")
	public List<Product> FindAll(){
		return  ProductService.readAllProducts();
	}

	@GetMapping("/Products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		return ProductService.readProduct(id);
	}
	
	@GetMapping("/Products1")
	public ResponseEntity<Product> getProductByParam(@RequestParam("id") long id) {
		return ProductService.readProductByParam(id);	
	}

	@PostMapping("/Products/{id_fournisseur}")
	public ResponseEntity<Void> AddProduct (@RequestBody Product Product, @PathVariable("id_fournisseur") long id_fournisseur ) {
		return ProductService.addProduct(Product, id_fournisseur);
	}

	@PostMapping("/list_Products")
	public ResponseEntity<Void> AddListProduct (@RequestBody List<Product> Products) {
		return ProductService.AddListProduct(Products); 
	}

	@PutMapping("Products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product Product) {
		return ProductService.modifiedProduct(id, Product);
	}

    @DeleteMapping("/Products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
		return ProductService.deleteProduct(id);
	}

	@DeleteMapping("/Products")
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		return ProductService.deleteproducts();
	}

}
