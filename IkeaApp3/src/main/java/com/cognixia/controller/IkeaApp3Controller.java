package com.cognixia.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.model.Product;
import com.cognixia.service.IkeaApp3Service;

@RestController
@RequestMapping("/product")
public class IkeaApp3Controller {

	@Autowired
	private IkeaApp3Service is;

	//Get all products
	@GetMapping("/")
	public List<Product> getAllProducts(){
		return is.getAllProducts();
	}

	//Get all details for a product by id
	@GetMapping("/id/{id}")
	public List<Product> getAllDetails(@PathVariable int id){
		return is.getProductId(id);
	}


	//Product Filter: Get name, code, rating, quantity of Product by category
	@GetMapping("/{category}")
	public List<String> getCategory(@PathVariable String category){
		return is.getCategory(category);
	}
	
	//Product Availability: Get inStock and Quantity of Product by code
	@GetMapping("/code/{code}")
	public List<String> getCode(@PathVariable String code){
		return is.getCode(code);
	}
	
	//Product cost with tax
	@GetMapping("/cost/{id}")
	public String productPrice(@PathVariable int id){
		return is.productPrice(id);
	}

	//Product cost with discount
	@GetMapping("/discount/{id}")
	public String discountPrice(@PathVariable int id){
		return is.discountPrice(id);
	}
	/***************************CRUD***************************/
	//Create - POST
	@PostMapping("/")
	public void saveProduct(@RequestBody Product product) {
		is.saveProduct(product);
	}


	//Update - PUT
	@PutMapping("/id/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer id){
		try {
			Product existProduct = is.getId(id);
			if(existProduct != null) {
				existProduct.setId(product.getId());
				existProduct.setName(product.getName());
				existProduct.setCode(product.getCode());
				existProduct.setCategory(product.getCategory());
				existProduct.setPrice(product.getPrice());
				existProduct.setQuantity(product.getQuantity());
				existProduct.setInStock(product.isInStock());
				existProduct.setRating(product.getRating());
				is.saveProduct(existProduct);

			}

			return new ResponseEntity<>(HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Delete - DELETE
	@DeleteMapping("/rating/{rating}")
	public void delete(@PathVariable Integer rating) {
		is.deleteByRating(rating);
	} 


}
