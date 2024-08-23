package com.product_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDTO {

	private long id;
	private String code;
	private String name;
	private double price;
	private String batch;
	
    @JsonIgnore
	private String error;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
	public ProductDTO(long id, String code, String name, double price, String batch) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.batch = batch;
	}
	public ProductDTO() {

	}
	
	public ProductDTO(String errorMessage) {
		this.error=errorMessage;
	}
	
}
