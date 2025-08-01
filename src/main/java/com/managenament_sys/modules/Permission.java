package com.managenament_sys.modules;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Permission {
	
	@Id
	@GeneratedValue
    private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(unique = true, nullable = false)
	private Levels name;

	public Levels getName() {
		return name;
		
	}
	
	
}
