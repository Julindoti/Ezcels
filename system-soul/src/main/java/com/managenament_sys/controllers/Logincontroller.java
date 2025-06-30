package com.managenament_sys.controllers;

import java.util.List;

import com.managenament_sys.Levels;
import com.managenament_sys.Usuario;
import com.managenament_sys.service.UsuarioService;

public class Logincontroller {
	private List <Usuario> LoggedUser;
	boolean pass= false;
	
	public void setUser(List<Usuario> Loggeduser){
		
		this.LoggedUser=Loggeduser;
		
		applyPermission(false);
	}
	public void applyPermission() {}
	
	public void applyPermission(boolean pass) {
		
		if(	LoggedUser.get(0).getLevel() != Levels.ADMIN){
		   System.out.println(LoggedUser.get(0).getUsername()+" "+"Você não e'admin, não possui permissão para acessar esses arquivos ");
		   this.pass=false;
		   return;
		}	
			else if (LoggedUser.get(0).getLevel() == Levels.ADMIN){
				
				
				System.out.println("Seja bem vindo admin "+ LoggedUser.get(0).getUsername()+" !");
				this.pass=true;
				return;
			}
			
		}
		
		
	}
