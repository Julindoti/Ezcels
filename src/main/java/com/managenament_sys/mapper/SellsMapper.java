package com.managenament_sys.mapper;

import org.mapstruct.Mapper;

import com.managenament_sys.dto.SellsDTO;
import com.managenament_sys.modules.Vendas;

@Mapper(componentModel = "spring")
public interface SellsMapper {
		SellsDTO toDTO(Vendas sell);
		Vendas toEntity(SellsDTO dto);
}
