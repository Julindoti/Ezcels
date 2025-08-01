package com.managenament_sys.service;

import java.util.List;

import com.managenament_sys.dto.SellsDTO;
import com.managenament_sys.modules.Vendas;

public interface SellsService {
	List<SellsDTO> findAll();
	SellsDTO save(SellsDTO dto);
}
