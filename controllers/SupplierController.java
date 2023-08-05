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

import com.example.demo.models.Supplier;
//@CrossOrigin(origins = "http://localhost:8080")
import com.example.demo.services.SupplierService;


@RestController
@RequestMapping("/api")

public class SupplierController {

	@Autowired
    private SupplierService SupplierService;
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

	
	@GetMapping("/Suppliers")
	public List<Supplier> GetSupplier(){
		return  SupplierService.read();
	}

	@GetMapping("/Suppliers/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable("id") long id) {
		/*Optional<Supplier> SupplierData = SupplierRepository.findById(id);

		if (SupplierData.isPresent()) {
			return new ResponseEntity<>(SupplierData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
		return SupplierService.readSupplier(id);
	}
	/*@GetMapping("/Suppliers/{id}/adrress/{id_address}")
	public ResponseEntity<Supplier> getAddressForSupplier(@PathVariable("id") long id,@PathVariable("id_address")long id_address) {
		Optional<Supplier> SupplierData = SupplierRepository.findById(id);

		if (SupplierData.isPresent()) {
			return new ResponseEntity<>(SupplierData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	@GetMapping("/Suppliers1")
	public ResponseEntity<Supplier> getSupplierByParam(@RequestParam("id") long id) {
		/*Optional<Supplier> SupplierData = SupplierRepository.findById(id);
			System.out.println("je suis dans le endpoint avec id = "+id);
		if (SupplierData.isPresent()) {
			System.out.println("j ai vue le Supplier avec id = " + id);
			return new ResponseEntity<>(SupplierData.get(), HttpStatus.OK);
			
		} else {
			System.out.println("j n ai pas vue le Supplier avec id = " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
		return SupplierService.readSupplierId(id);
	}
	@PostMapping("/Suppliers")
	public ResponseEntity<Void> AddSupplier (@RequestBody Supplier Supplier) {
		/*try {
			 SupplierRepository.save(Supplier);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return SupplierService.addSupplier(Supplier);
	}
	@PostMapping("/list_Suppliers")
	public ResponseEntity<Void> AddListSupplier (@RequestBody List<Supplier> Suppliers) {
		/*try{ 
			for (Supplier Supplier : Suppliers) {
            	SupplierRepository.save(Supplier);
			}
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return SupplierService.addSupplierList(Suppliers)
;	}

	@PutMapping("Suppliers/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable("id") long id, @RequestBody Supplier Supplier) {
		/*Optional<Supplier> SupplierData = SupplierRepository.findById(id);

		if (SupplierData.isPresent()) {
			Supplier _Supplier = SupplierData.get();
			_Supplier.setNom(Supplier.getNom());
			_Supplier.setAddress(Supplier.getAddress());
			_Supplier.setEmail(Supplier.getEmail());
			_Supplier.setStatus(Supplier.getStatus());
			_Supplier.setTelephone(Supplier.getTelephone());
			return new ResponseEntity<>(SupplierRepository.save(_Supplier), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
		return SupplierService.modifiedSupplier(id, Supplier);
	}
    @DeleteMapping("/Suppliers/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		/*try {
			SupplierRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return SupplierService.deleteSupplier(id);
	}

	@DeleteMapping("/Suppliers")
	public ResponseEntity<HttpStatus> deleteAll() {
		/*try {
			SupplierRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/
		return SupplierService.deleteAllSupplier();

	}

}
