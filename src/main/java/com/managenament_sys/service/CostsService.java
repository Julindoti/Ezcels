package com.managenament_sys.service;

import java.util.List;

import com.managenament_sys.dto.CostsDTO;

public interface CostsService {
	List<CostsDTO> findAll();
	CostsDTO save(CostsDTO dto);
}
