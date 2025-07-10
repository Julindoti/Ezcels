package com.managenament_sys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.managenament_sys.dto.ProductDTO;
import com.managenament_sys.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController{
	

    private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	@GetMapping
	public List<ProductDTO> getAll(){
		return service.findAll();	
	}
	@PostMapping
	public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto){
			return ResponseEntity.ok(service.save(dto));
		
	}
	
}