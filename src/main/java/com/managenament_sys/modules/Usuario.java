package com.managenament_sys.modules;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Levels level;
	
	// Remove static list as we'll use database instead
	// public static List<Usuario> users;
	
	public Usuario() {}
	
	public Usuario(String name, String email, String password, Levels level) {
		setUsername(name);
		setUseremail(email);	
		setUserpassword(password);
		setLevel(level);
	}
	
	// Getters and setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setLevel(Levels level) {
		this.level = level;
	}
	
	public Levels getLevel() {
		return this.level;
	}
	
	public String getUsername() {
		return this.name;
	}
	
	public void setUsername(String name) {
		this.name = name;
	}
	
	public String getUseremail() {
		return this.email;		
	}
	
	public void setUseremail(String email) {
		this.email = email;	
	}
	
	public String getUserpassword() {
		return this.password;
	}
	
	public void setUserpassword(String password) {
		this.password = password;	
	}
}
