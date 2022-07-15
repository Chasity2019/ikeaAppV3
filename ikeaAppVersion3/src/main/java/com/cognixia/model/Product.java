package com.cognixia.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@Column(name="category")
	private String category;
	@Column(name="price")
	private Double price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="inStock")
	private boolean inStock;
	@Column(name="rating")
	private int rating;



	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product(int id, String name, String code, String category, Double price, int quantity, boolean inStock,
			int rating) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.inStock = inStock;
		this.rating = rating;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public boolean isInStock() {
		return inStock;
	}



	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code + ", category=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", inStock=" + inStock + ", rating=" + rating + "]";
	}

	
	

	

	
	
}
