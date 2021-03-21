
package controllers;

import models.Usuario;
import play.libs.Crypto;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

public class Login extends Usuarios {

		public static void login() {
			render();
		}
		
		public static void autenticar(String email, String senha) {
			
			Usuario usuario = Usuario.find("email = ? and senha = ?", email, Crypto.passwordHash(senha)).first();
			
			if (usuario == null) {
				flash.error("Usuário ou senha incorretos");
				login();
				
			} else {
				session.put("usuarioID", usuario.id);
				session.put("usuarioNome", usuario.nome);
				session.put("usuarioEmail", usuario.email);
				session.put("usuarioSenha", usuario.senha);
				
				Application.index();
			}
		}
		public static void logout() {
			session.clear();
			login();
		}
}
