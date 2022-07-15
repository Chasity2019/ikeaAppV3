package com.cognixia.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognixia.model.Product;
import com.cognixia.repository.IkeaAppVersion3Repository;

@Service
@Transactional
public class IkeaAppVersion3Service {

	@Autowired
	IkeaAppVersion3Repository ir;

	DecimalFormat df = new DecimalFormat("#.##");

	//Get all products
	public List<Product> getAllProducts(){
		return ir.findAll();
	}


	//Get details for a product by ID
	public List<Product> getProductId(int id){
		return ir.findById(id);
	}

	//Get product name, code, quantity, and rating
	public List<String> getCategory(String category) {
		List<Product> products = ir.findByCategory(category);
		List<String> filteredList = new ArrayList<String>();
		for(Product p : products) {
			filteredList.add("name: " + p.getName() + "| Product code: " + p.getCode() + "| Product rating: " + p.getRating() + "| Product quantity: " + p.getQuantity());
		}
		return filteredList;
	} 
	

	//Get inStock and Quantity of product by code
	public List<String> getCode(String code) {
		List<Product> products = ir.findByCode(code);
		List<String> filteredListCode = new ArrayList<String>();
		for(Product p : products) {
			if(p.isInStock() && p.getQuantity()>0) {
			filteredListCode.add("Product in stock: " + p.isInStock() + " and Product quantity: " + p.getQuantity());
			}
		}
		return filteredListCode;
		}
	
	//get cost plus tax
	public String productPrice(int id){
		List<Product> products = ir.findById(id);
		for(Product p : products) {
			if(p.getId() == id) {
				double tax = p.getPrice() * .13;
				double total = p.getPrice() + tax;
				String plusTax = "Price plus tax: $" + df.format(total);			
		
				return plusTax;
			}
		}
		return null;
	}
		
	//get cost with discount
	public String discountPrice(int id){
		List<Product> products = ir.findById(id);
		for(Product p : products) {
			if(p.getId() == id) {
				double tax = p.getPrice() * .13;
				double total = p.getPrice() + tax;
				double discount = (total * .10) + total;
				String plusDiscount = "With your TEN PERCENT discount your new price is : $" + df.format(discount);			
		
				return plusDiscount;
			}
		}
		return null;
	}

	
	/***********************************CRUD***********************************/
	//Create - POST
	public void saveProduct(Product product) {
		ir.save(product);
	}
	

	//Read - GET
	public Product getId(Integer id) {
		return ir.findById(id).get();
	}

	//Update - PUT
	public void updateProduct(Product product) {
		ir.save(product);
	}

	//Delete - DELETE
	public void deleteByRating(Integer rating) {
		ir.deleteByRating(rating);
	}
	

}
