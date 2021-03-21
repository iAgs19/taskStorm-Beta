package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import play.data.validation.Email;
import play.data.validation.Equals;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;
import play.libs.Crypto;

@Entity
public class Usuario extends Model {
	@Required
	public String nome;
	
	@Required
	@Email
	@Unique
	public String email;
	
	@Required
	@Equals(value="confirmacaoSenha", message="A senha de confirmação está diferente.")
	public String senha;
	
	@Transient
	public String confirmacaoSenha;
	
	@OneToMany(mappedBy="usuario")
	public List<Tarefa> tarefas;
	
	public void setSenha (String s) {
		senha = Crypto.passwordHash(s);
	}
	
	public void setConfirmacaoSenha (String s) {
		confirmacaoSenha = Crypto.passwordHash(s);
	}
}
