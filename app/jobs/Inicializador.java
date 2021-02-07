package jobs;

import models.Tarefa;
import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Inicializador extends Job {

	public void doJob() {
			if (Usuario.count() == 0) {
				Fixtures.loadModels("testeData.yml");
			}
			if (Tarefa.count() == 0) {
				Fixtures.loadModels("testeData.yml");
		}
	}
}