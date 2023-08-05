package com.example.demo.services;

import java.util.Optional;
import java.util.List;
//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.models.Supplier;
import com.example.demo.repositories.SupplierRepository;
import lombok.Data;

@Data
@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

	public List<Supplier> read(){
		return  supplierRepository.findAll();
	}

	//@GetMapping("/Suppliers/{id}")
	public ResponseEntity<Supplier> readSupplier( long id) {
		Optional<Supplier> SupplierData = supplierRepository.findById(id);

		if (SupplierData.isPresent()) {
			return new ResponseEntity<>(SupplierData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/*@GetMapping("/Suppliers/{id}/adrress/{id_address}")
	public ResponseEntity<Supplier> getAddressForSupplier(@PathVariable("id") long id,@PathVariable("id_address")long id_address) {
		Optional<Supplier> SupplierData = supplierRepository.findById(id);

		if (SupplierData.isPresent()) {
			return new ResponseEntity<>(SupplierData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/
	//@GetMapping("/Suppliers1")
	public ResponseEntity<Supplier> readSupplierId( long id) {
		Optional<Supplier> SupplierData = supplierRepository.findById(id);
			System.out.println("je suis dans le endpoint avec id = "+id);
		if (SupplierData.isPresent()) {
			System.out.println("j ai vue le Supplier avec id = " + id);
			return new ResponseEntity<>(SupplierData.get(), HttpStatus.OK);
			
		} else {
			System.out.println("j n ai pas vue le Supplier avec id = " + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//@PostMapping("/Suppliers")
	public ResponseEntity<Void> addSupplier ( Supplier Supplier) {
		try {
			 supplierRepository.save(Supplier);
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//@PostMapping("/list_Suppliers")
	public ResponseEntity<Void> addSupplierList (List<Supplier> Suppliers) {
		try{ 
			for (Supplier Supplier : Suppliers) {
            	supplierRepository.save(Supplier);
			}
			return new ResponseEntity<>( HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//@PutMapping("Suppliers/{id}")
	public ResponseEntity<Supplier> modifiedSupplier( long id, Supplier supplier) {
		Optional<Supplier> SupplierData = supplierRepository.findById(id);

		if (SupplierData.isPresent()) {
			Supplier _Supplier = SupplierData.get();
			_Supplier.setNom(supplier.getNom());
			_Supplier.setAddress(supplier.getAddress());
			_Supplier.setEmail(supplier.getEmail());
			_Supplier.setStatus(supplier.getStatus());
			_Supplier.setPhone(supplier.getPhone());
			return new ResponseEntity<>(supplierRepository.save(_Supplier), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    //@DeleteMapping("/Suppliers/{id}")
	public ResponseEntity<HttpStatus> deleteSupplier(long id) {
		try {
			supplierRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//@DeleteMapping("/Suppliers")
	public ResponseEntity<HttpStatus> deleteAllSupplier() {
		try {
			supplierRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}