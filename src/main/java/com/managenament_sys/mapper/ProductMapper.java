package com.managenament_sys.mapper;

import org.mapstruct.Mapper;

import com.managenament_sys.dto.ProductDTO;
import com.managenament_sys.modules.Produto;


@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductDTO toDTO(Produto product);
	Produto toEntity(ProductDTO dto);
	
}

