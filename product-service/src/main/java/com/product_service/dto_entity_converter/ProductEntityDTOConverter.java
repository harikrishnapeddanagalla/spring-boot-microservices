package com.product_service.dto_entity_converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product_service.dto.ProductDTO;
import com.product_service.model.Product;

@Component
public class ProductEntityDTOConverter {


	@Autowired
	private ModelMapper modelMapper;
	
	public Product dtoToProductConverter(ProductDTO productDTO) {
		
		Product product = modelMapper.map(productDTO, Product.class);
		
		return product;
		
	}
	
	public ProductDTO productToProductDTOConverter(Product product) {
		
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
		
		return productDTO;
		
	}
}
