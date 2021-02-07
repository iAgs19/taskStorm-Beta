package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.AndamentoTarefa;
import enums.TipoTarefa;
import play.db.jpa.Model;

@Entity
public class Tarefa extends Model{

	@Temporal(TemporalType.DATE)
	public Date prazo;
	
	public String anotacao;
	public String titulo;
	public TipoTarefa tipoTarefa;
	public AndamentoTarefa andTarefa;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	public Usuario usuario;
	
	
}
