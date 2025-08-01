package com.managenament_sys.mapper;

import org.mapstruct.Mapper;

import com.managenament_sys.dto.UserDTO;
import com.managenament_sys.modules.Usuario;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserDTO toDTO(Usuario user);
	Usuario toEntity(UserDTO dto);
	
}
