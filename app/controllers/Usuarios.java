package controllers;

import java.util.List;

import models.Tarefa;
import models.Usuario;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;


public class Usuarios extends Controller {

	public static void form() {
		render();
	}
	
	public static void formEdicao() {
	
		render();
	}

	public static void salvar(Usuario usu, String senha) {

		if (senha.equals("") == false) {
			usu.senha = senha;
			
			if(senha.length() < 6) {
				validation.addError("usu.senha", "A senha deve conter no mínimo 6 digítos.");
			}
		}
		
		validation.valid(usu);
		
		if (validation.hasErrors()) {
			validation.keep();

			flash.error("Falha ao cadastrar usuário.");
			params.flash();
			form();
		}

		usu.save();
		flash.success("Usuário cadastrado com sucesso.");
		Login.login();
	}
	
	public static void listar() {
		List<Usuario> lista = Usuario.findAll();
		render(lista);
	}
	
	public static void editar() {
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuLogado = Usuario.findById(usuarioID);

		renderTemplate("Usuarios/formEdicao.html", usuLogado);
	}
	
	public static void salvarEdicao(Usuario usu, String senha) {
		if (senha.equals("") == false) {
			usu.senha = senha;
			
			if(senha.length() < 6) {
				validation.addError("usu.senha", "A senha deve conter no mínimo 6 digítos.");
			}
		}
		
		validation.valid(usu);
		
		if (validation.hasErrors()) {
			validation.keep();

			flash.error("Falha ao editar usuário.");
			params.flash();
			formEdicao();
		}
		
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuLogado = Usuario.findById(usuarioID);
		
		usuLogado.nome = usu.nome;
		usuLogado.email = usu.email;
		usuLogado.senha = usu.senha; 
		usuLogado.save();
		
		flash.success("Usuário editado com sucesso.");
		Application.index();
	}
	

	public static void deletar() {
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuarioLogado = Usuario.findById(usuarioID);
		
		

		flash.success("Usuário deletado com sucesso.");
		Login.login();
	}

}
