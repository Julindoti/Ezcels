package com.managenament_sys.modules;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Roles {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name= "roles_permissions",
		joinColumns= @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "permission_id") 
    )
	private Set<Permission> permissions;
	
	public Set<Permission> getPermissons(){
		return permissions;
		
	}
	
}
