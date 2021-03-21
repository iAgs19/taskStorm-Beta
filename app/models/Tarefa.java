package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.AndamentoTarefa;
import enums.TipoTarefa;
import play.data.validation.InFuture;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Tarefa extends Model{

	@Temporal(TemporalType.DATE)
	@InFuture(message="Insira uma data no futuro.")
	public Date prazo;
	
	@Required
	public String anotacao;
	@Required
	public String titulo;
	@Required
	public TipoTarefa tipoTarefa;
	@Required
	@Enumerated(EnumType.STRING)
	public AndamentoTarefa andamentoTarefa;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	public Usuario usuario;
	
	
}
