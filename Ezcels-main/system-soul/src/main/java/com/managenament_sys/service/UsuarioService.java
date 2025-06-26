package com.managenament_sys.service;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.Scanner;


import com.managenament_sys.modules.Levels;
import com.managenament_sys.modules.Usuario;

public class UsuarioService {
	
	
	public static void CadastroUser(){

	       try{
			Scanner sc= new Scanner(System.in);

			System.out.println("----------CADASTRO DE USUARIO----------------");
			
			System.out.println("Digite seu Nome de uasuario");
			String nomeU= sc.nextLine();
            
			System.out.println("Digite seu email");

			String emailU= sc.nextLine();

			System.out.println("Digite sua senha");
			String pass= sc.nextLine();

			Usuario u= new Usuario(nomeU, emailU, pass, Levels.USER);

		} catch(Exception e){e.printStackTrace();}

        if ()


	}



	/*public static void UpUser(List <Usuario> user) {
		
		   List <Usuario> UP = Usuario.users;
		   Scanner input = new Scanner(System.in);
		   
		   System.out.println("Digite seu email:");
		   String email = input.next();
		   
		   System.out.println("Digite sua senha:");
		   String password= input.next();
		   System.out.println(password + email );
		   
		   for ( int i= 0; i < Usuario.users.size(); i++) {
			   if (email.equals(Usuario.users.get(i).getUseremail())  && password.equals(Usuario.users.get(i).getUserpassword())){
				   System.out.println("email valido");
				  
			   }else {
				   System.out.println("Usuario ou senha incorretos.Por favor tente novamente:");
				  
			   }
		   }
		
	}*/

}
