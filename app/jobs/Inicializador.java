package jobs;

import java.text.SimpleDateFormat;

import enums.AndamentoTarefa;
import enums.TipoTarefa;
import models.Tarefa;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Inicializador extends Job {

	public void doJob() throws Exception {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		if (Usuario.count() == 0 || Tarefa.count() == 0) {
			Usuario usuario1 = new Usuario();
			usuario1.nome = "Agnnes";
			usuario1.email = "agnnes19@gmail.com";
			usuario1.senha = "123456";
			usuario1.save();

			Tarefa tarefa4 = new Tarefa();
			tarefa4.titulo = "Organizar o quarto";
			tarefa4.prazo = formato.parse("06/03/2021");
			tarefa4.tipoTarefa = TipoTarefa.Domestica;
			tarefa4.andamentoTarefa = AndamentoTarefa.Iniciada;
			tarefa4.anotacao = "Limpar e colocar as coisas no lugar";
			tarefa4.usuario = usuario1;
			tarefa4.save();

			Tarefa tarefa5 = new Tarefa();
			tarefa5.titulo = "Fazer a feira";
			tarefa5.prazo = formato.parse("04/03/2021");
			tarefa5.tipoTarefa = TipoTarefa.Domestica;
			tarefa5.andamentoTarefa = AndamentoTarefa.EmAndamento;
			tarefa5.anotacao = "Não esquecer de comprar a comida da cachorra";
			tarefa5.usuario = usuario1;
			tarefa5.save();

			Tarefa tarefa6 = new Tarefa();
			tarefa6.titulo = "Terminar de assistir Bridgerton";
			tarefa6.prazo = formato.parse("06/03/2021");
			tarefa6.tipoTarefa = TipoTarefa.Lazer;
			tarefa6.andamentoTarefa = AndamentoTarefa.EmAndamento;
			tarefa6.anotacao = "Continuar a partir do 5";
			tarefa6.usuario = usuario1;
			tarefa6.save();

			Tarefa tarefa7 = new Tarefa();
			tarefa7.titulo = "Terminar de ler o livro";
			tarefa7.prazo = formato.parse("25/03/2021");
			tarefa7.tipoTarefa = TipoTarefa.Lazer;
			tarefa7.andamentoTarefa = AndamentoTarefa.Iniciada;
			tarefa7.anotacao = "Continuar a partir da página 30";
			tarefa7.usuario = usuario1;
			tarefa7.save();

			Usuario usuario2 = new Usuario();
			usuario2.nome = "Felipe";
			usuario2.email = "felipe@gmail.com";
			usuario2.senha = "123456";
			usuario2.save();

			Tarefa tarefa2 = new Tarefa();
			tarefa2.titulo = "Projeto de Qualidade de Vida";
			tarefa2.prazo = formato.parse("15/02/2021");
			tarefa2.tipoTarefa = TipoTarefa.Escolar;
			tarefa2.andamentoTarefa = AndamentoTarefa.Concluido;
			tarefa2.anotacao = "Concluir o projeto até a proxima semana.";
			tarefa2.usuario = usuario2;
			tarefa2.save();

			Tarefa tarefa10 = new Tarefa();
			tarefa10.titulo = "Projeto Gestão Organizacional - Empresa";
			tarefa10.prazo = formato.parse("25/03/2021");
			tarefa10.tipoTarefa = TipoTarefa.Escolar;
			tarefa10.andamentoTarefa = AndamentoTarefa.Iniciada;
			tarefa10.anotacao = "Definir as missões, as visões e os valores da sua empresa.";
			tarefa10.usuario = usuario2;
			tarefa10.save();

			Tarefa tarefa11 = new Tarefa();
			tarefa11.titulo = "Aumentar a produção do tecido branco";
			tarefa11.prazo = formato.parse("25/03/2021");
			tarefa11.tipoTarefa = TipoTarefa.Profissional;
			tarefa11.andamentoTarefa = AndamentoTarefa.EmAndamento;
			tarefa11.anotacao = "Adquirir mais matéria-prima para aumento da produção de tecido branco";
			tarefa11.usuario = usuario2;
			tarefa11.save();

			Tarefa tarefa12 = new Tarefa();
			tarefa12.titulo = "Aumentar o alcance de internet";
			tarefa12.prazo = formato.parse("29/03/2021");
			tarefa12.tipoTarefa = TipoTarefa.Profissional;
			tarefa12.andamentoTarefa = AndamentoTarefa.Iniciada;
			tarefa12.anotacao = "Contruir mais torres de distribuição de internet.";
			tarefa12.usuario = usuario2;
			tarefa12.save();

		}
	}
}