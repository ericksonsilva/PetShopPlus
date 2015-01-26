package br.com.petshopplus.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
	}
	
	@Path("principal")
	public void principal() {
	}

	@Path("login")
	public void login() {
	}
	@Path("/")
	public void index() {
		result.redirectTo(this).login();	
	}
	
	@Post("logar")
	public void logar() {
		System.out.println("TESTE");
		result.redirectTo(this).login();
	}
	
	
	
}