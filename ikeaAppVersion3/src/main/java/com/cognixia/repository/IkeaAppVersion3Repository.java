package com.cognixia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cognixia.model.Product;

@RepositoryRestResource
public interface IkeaAppVersion3Repository extends JpaRepository<Product, Integer>{
	List<Product> findByName(String name);
	List<Product> findById(int id);
	List<Product> deleteByRating(int rating);

	@Query("select p from Product p where category LIKE %?1%")
	List<Product> findByCategory(String category);
	
	@Query("select p from Product p where p.code LIKE %?1% and p.inStock is true and p.quantity > 0")
	List<Product> findByCode(String code);
	
	@Query("select p from Product p where rating=10")
	List<Product> getMaxRating();
	
	
	
}