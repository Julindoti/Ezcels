package com.managenament_sys.mapper;

import org.mapstruct.Mapper;

import com.managenament_sys.dto.CostsDTO;
import com.managenament_sys.modules.Gastos;

@Mapper(componentModel = "spring")
public interface CostsMapper {
	CostsDTO toDTO(Gastos costs);
	Gastos toEntity(CostsDTO dto);
}
