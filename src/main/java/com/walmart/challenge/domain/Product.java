package com.walmart.challenge.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("products")
public class Product {
	@Id
	private String _id;
	private Integer id;
	private String brand;
	private String description;
	private String image;
	private long price;
	private long oldPrice;
	private int discountRate;
	
	public Product() {super();}
	
	public Product(Integer id, String brand, String description, String image, long price, long oldPrice,
			int discountRate) {
		super();
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.price = price;
		this.oldPrice = oldPrice;
		this.discountRate = discountRate;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public long getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(long oldPrice) {
		this.oldPrice = oldPrice;
	}

	
	
}
