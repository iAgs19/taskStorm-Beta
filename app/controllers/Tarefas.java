package controllers;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Id;

import com.sun.javafx.tk.Toolkit.Task;

import enums.TipoTarefa;
import models.Tarefa;
import models.Usuario;
import play.mvc.Controller;

public class Tarefas extends Controller{
	
	public static void form() {
		List<TipoTarefa> tipoTarefas = Arrays.asList(TipoTarefa.values());
		List<Usuario> usuarios = Usuario.findAll();
		render(tipoTarefas, usuarios);
	}
	
	public static void salvar(Tarefa task) {
		task.save();
		form();
	}
	
	public static void listar() {
		List<Tarefa> lista = Tarefa.findAll();
		render(lista);
	}
	public static void editar(long id) {
		Tarefa task = Tarefa.findById(id);
		List<TipoTarefa> tipoTarefas = Arrays.asList(TipoTarefa.values());
		renderTemplate("Tarefas/form.html", task, tipoTarefas);
	}
	public static void deletar(long id) {
		Tarefa task = Tarefa.findById(id);
		task.delete();
		
		listar();
	} 

}
