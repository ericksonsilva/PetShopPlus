package br.com.petshopplus.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.petshopplus.model.Login;
import br.com.petshopplus.safety.Restrito;
import br.com.petshopplus.safety.Session;

@Controller
public class IndexController {

	private final Result result;
	
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result){
		this.result = result;
	}
	
	@Path("/home")
	@Restrito
	public void home() {
	}

	@Path("/login")
	public void login(Login login) {
		if ((login.getSenha().endsWith("admin")) && (login.getUsuario().endsWith("admin"))){
			Session.setSession(login);
			result.redirectTo(this).home();
		} else{
			result.redirectTo(this).index();
		}
	}
	
	@Path("/")
	public void index() {	
	}
	
	@Path("/logout")
	@Restrito
	public void logout() {
		Session.logout();
		result.redirectTo("/");
	}
	
}