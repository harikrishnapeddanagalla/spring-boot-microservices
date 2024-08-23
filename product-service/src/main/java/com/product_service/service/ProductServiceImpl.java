package com.product_service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service.model.Product;
import com.product_service.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		
	    logger.info("Saving product: {}", product);
	    
	    if (product == null) {
	        throw new IllegalArgumentException("Product cannot be null");
	    }
	    Product savedProduct = productRepo.save(product);
	    
	    logger.info("Product saved: {}", savedProduct);
	    
	    return savedProduct;
	}

	
	@Override
	public List<Product> getAllProducts() {
		
		try {
			
			List<Product> products = productRepo.findAll();
			
			logger.info("Fetched all products: {}", products);
			
			return products;
			
		} catch (Exception e) {
			logger.error("Error fetching products: {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}


	@Override
	public Product getProductDetailsByCode(String prodCode) {
		
		try {
			
			Product product = productRepo.findByCode(prodCode);
			
			logger.info("Fetched Product Info using product code : {}", product);
			return product;
			
		} catch (Exception e) {
			logger.error("Error fetching product info: {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
