package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Login extends Usuarios {

		public static void login() {
			render();
		}
		
		public static void autenticar(String email, String senha, Usuario usu) {
			
			Usuario usuario = Usuario.find("email = ? and senha = ?", email, senha).first();
			
			if (usu == null) {
				login();
				flash.error("Usuário ou senha incorretos");
				
			} else {
				session.put("usuario.email", usu.email);
				session.put("usuario.senha", usuario.senha);
				
				Application.index();
			}
			if(email.equals("admin") && senha.equals("admin") ) {
				Application.index();
			}
				else{
					flash.error("Usuário ou senha incorretos");
					login();
				}
		}
		public static void logout() {
			session.clear();
			login();
		}
}
