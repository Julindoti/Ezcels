package com.managenament_sys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.managenament_sys.dto.ProductDTO;
import com.managenament_sys.mapper.ProductMapper;
import com.managenament_sys.modules.Produto;
import com.managenament_sys.repository.ProductRepository;
import com.managenament_sys.service.*;

@Service
public  class ProductServiceBrute implements ProductService{
	
		private final ProductRepository repo;
	
		private final ProductMapper mapper;
	
	public ProductServiceBrute(ProductRepository repo, ProductMapper mapper){
		this.repo= repo;
		this.mapper= mapper;		
	}
	@Override
	public List <ProductDTO> findAll(){
		return repo.findAll().stream()
				.map(mapper::toDTO)
				.collect(Collectors.toList());
		
	}
	@Override
	public ProductDTO save(ProductDTO dto){
		  Produto entity =  mapper.toEntity(dto);
		  Produto saved = repo.save(entity);	
		  return mapper.toDTO(saved);
		
		
	}
		
}
