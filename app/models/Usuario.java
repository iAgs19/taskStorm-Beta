package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	public String nome;
	public String email;
	public String senha;
	
	@OneToMany(mappedBy="usuario")
	public List<Tarefa> tarefas;
}
