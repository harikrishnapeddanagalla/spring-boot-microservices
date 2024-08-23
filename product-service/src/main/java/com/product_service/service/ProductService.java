package com.product_service.service;

import java.util.List;

import com.product_service.model.Product;

public interface ProductService {

	Product saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductDetailsByCode(String prodCode);
}
