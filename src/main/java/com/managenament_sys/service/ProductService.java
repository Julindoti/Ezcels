package com.managenament_sys.service;

import java.util.List;

import com.managenament_sys.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAll();
	ProductDTO save(ProductDTO dto);
}
