package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import enums.TipoTarefa;
import models.*;

public class Application extends Controller {
	
	@Before
	public void checarUsuarioLogado() {
		if(session.get("usuarioID") == null) {
			Login.login();
		}
	}
	
    public static void index() {
    	String usuarioNome = session.get("usuarioNome");
    	String usuarioID = session.get("usuarioID");
    	
        render(usuarioNome, usuarioID);
    }
    
}