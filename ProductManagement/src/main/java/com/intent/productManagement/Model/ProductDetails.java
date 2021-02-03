package com.intent.productManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	



	private String name;
	private String description;
	private String image;
	private Double price;
	private Integer quantity;
	private Boolean status;
	private int stockAvailabilty;
	private int type;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getStockAvailabilty() {
		return stockAvailabilty;
	}
	public void setStockAvailabilty(int stockAvailabilty) {
		this.stockAvailabilty = stockAvailabilty;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	

	public ProductDetails() {
	}
	
	
	
	public ProductDetails(long id, String name, String description, String image, Double price, Integer quantity,
			Boolean status, int stockAvailabilty, int type) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
		this.stockAvailabilty = stockAvailabilty;
		this.type = type;
	}
	
}
