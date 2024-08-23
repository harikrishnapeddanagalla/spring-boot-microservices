package com.product_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.dto.ProductDTO;
import com.product_service.dto_entity_converter.ProductEntityDTOConverter;
import com.product_service.model.Product;
import com.product_service.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProductController {

	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductEntityDTOConverter productEntityConverter;
	
	
	@PostMapping("/saveProduct")
	public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {

		logger.info("Saving product: {}", productDTO);
		
		try {

			if (productDTO == null) {
				throw new IllegalArgumentException("Product cannot be null");
			}
			Product product = productEntityConverter.dtoToProductConverter(productDTO);
			
			Product savedProduct = productService.saveProduct(product);
			
			ProductDTO responseDTOObject = productEntityConverter.productToProductDTOConverter(savedProduct);
			
			logger.info("Product saved: {}", savedProduct);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(responseDTOObject);
			
		} catch (IllegalArgumentException e) {
			
			logger.error("Invalid product: {}", e.getMessage());
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ProductDTO(e.getMessage()));
			
		} catch (Exception e) {
			logger.error("Error saving product: {}", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProductDTO("An error occurred"));
		}

	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		
		try {
			
			List<Product> allProducts = productService.getAllProducts();
			
			List<ProductDTO> dtoProducts = allProducts.stream()
					.map(product -> productEntityConverter.productToProductDTOConverter(product))
					.collect(Collectors.toList());
			
			logger.info("Fetched all products: {}", dtoProducts);
			
			return ResponseEntity.status(HttpStatus.OK).body(dtoProducts);
			
		} catch (Exception e) {
			logger.error("Error fetching products: {}", e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping("/getProduct/{prodCode}")
	public ResponseEntity<ProductDTO> getProductByCode(@PathVariable String prodCode) {
		
		if (prodCode == null || prodCode.isEmpty()) {
			ProductDTO errorDTO = new ProductDTO("Product code is required");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
		}
		try {
			Product product = productService.getProductDetailsByCode(prodCode);
			
			if (product == null) {
				ProductDTO errorDTO = new ProductDTO("Product not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
			}
			ProductDTO productDTO = productEntityConverter.productToProductDTOConverter(product);
			
			return ResponseEntity.status(HttpStatus.OK).body(productDTO);
			
		} catch (Exception e) {
			ProductDTO errorDTO = new ProductDTO("An error occurred");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
		}
	}
}
