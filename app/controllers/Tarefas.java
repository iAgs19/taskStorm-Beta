package controllers;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Id;

import com.sun.javafx.tk.Toolkit.Task;

import enums.AndamentoTarefa;
import enums.TipoTarefa;
import models.Tarefa;
import models.Usuario;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;


public class Tarefas extends Controller{
	
	public static void form() {
		List<TipoTarefa> tipoTarefas = Arrays.asList(TipoTarefa.values());
		List<AndamentoTarefa> andamentoTarefas = Arrays.asList(AndamentoTarefa.values());
		render(tipoTarefas, andamentoTarefas);
	}
	
	public static void salvar(@Valid Tarefa task) {
		
		if (validation.hasErrors()) {
			validation.keep();
			
			flash.error("Falha ao salvar tarefa.");
			params.flash();
			form();
		}
		
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuarioLogado = Usuario.findById(usuarioID);
		task.usuario = usuarioLogado;
		task.save();
		
		flash.success("Tarefa salva com sucesso.");
		listar();
	}
	
	public static void listar() {
		String busca = params.get("busca");
		
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuarioLogado = Usuario.findById(usuarioID);
		
		List<Tarefa> lista = usuarioLogado.tarefas;
		
		if (busca == null) {
			if(usuarioLogado == lista) {
			lista = Tarefa.findAll();
			}
		}else {
			lista = Tarefa.find("anotacao like ? or titulo like ?","%"+busca+"%","%"+busca+"%").fetch();
		}
		
		render(lista, usuarioLogado);
	}
	
	public static void listarEscolar() {
		String busca = params.get("busca");
		
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuarioLogado = Usuario.findById(usuarioID);
		List<Tarefa> lista2 = usuarioLogado.tarefas;
		
		if (busca == null) {
			
		lista2 = Tarefa.find("USUARIO_ID = ? AND TIPOTAREFA = 0", usuarioLogado).fetch();
		}else {
			lista2 = Tarefa.find("anotacao like ? or titulo like ?","%"+busca+"%","%"+busca+"%").fetch();
		}
		renderTemplate("Tarefas/listarEscolar.html", lista2, usuarioLogado);
	}
	
	public static void listarProfissional() {
		String busca = params.get("busca");
				
				Long usuarioID = Long.parseLong(session.get("usuarioID"));
				Usuario usuarioLogado = Usuario.findById(usuarioID);
				List<Tarefa> lista2 = usuarioLogado.tarefas;
				
				if (busca == null) {
					
				lista2 = Tarefa.find("USUARIO_ID = ? AND TIPOTAREFA = 1", usuarioLogado).fetch();
				}else {
					lista2 = Tarefa.find("anotacao like ? or titulo like ?","%"+busca+"%","%"+busca+"%").fetch();
				}
				renderTemplate("Tarefas/listarProfissional.html", lista2, usuarioLogado);
			}
	
	public static void listarDomestica() { 
		String busca = params.get("busca");
		
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuarioLogado = Usuario.findById(usuarioID);
		List<Tarefa> lista2 = usuarioLogado.tarefas;
		
		if (busca == null) {
			
		lista2 = Tarefa.find("USUARIO_ID = ? AND TIPOTAREFA = 2", usuarioLogado).fetch();
			
		
		}else {
			lista2 = Tarefa.find("anotacao like ? or titulo like ?","%"+busca+"%","%"+busca+"%").fetch();
		}
		
		renderTemplate("Tarefas/listarDomestica.html", lista2, usuarioLogado);
	}
	
	
	public static void listarLazer() {
String busca = params.get("busca");
		
		Long usuarioID = Long.parseLong(session.get("usuarioID"));
		Usuario usuarioLogado = Usuario.findById(usuarioID);
		List<Tarefa> lista2 = usuarioLogado.tarefas;
		
		if (busca == null) {
			
		lista2 = Tarefa.find("USUARIO_ID = ? AND TIPOTAREFA = 3", usuarioLogado).fetch();
		}else {
			lista2 = Tarefa.find("anotacao like ? or titulo like ?","%"+busca+"%","%"+busca+"%").fetch();
		}
		renderTemplate("Tarefas/listarLazer.html", lista2, usuarioLogado);
	}
	
	public static void editar(long id) {
		Tarefa task = Tarefa.findById(id);
		List<TipoTarefa> tipoTarefas = Arrays.asList(TipoTarefa.values());
		List<AndamentoTarefa> andamentoTarefas = Arrays.asList(AndamentoTarefa.values());
		renderTemplate("Tarefas/form.html", task, tipoTarefas, andamentoTarefas);
		
	}
	public static void deletar(long id) {
		Tarefa task = Tarefa.findById(id);
		task.delete();
		
		flash.success("Tarefa deletada com sucesso.");
		listar();
	} 

}
