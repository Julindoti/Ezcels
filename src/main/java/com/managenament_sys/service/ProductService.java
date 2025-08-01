package com.managenament_sys.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.managenament_sys.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAll();
	ProductDTO save(ProductDTO dto);
	ResponseEntity<Void> delete(@PathVariable Long id);
	ResponseEntity<ProductDTO> patch(@PathVariable Long id);
	}
