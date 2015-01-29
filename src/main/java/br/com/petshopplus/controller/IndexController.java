package br.com.petshopplus.controller;

import javax.inject.Inject;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.facade.PSPFacade;
import br.com.petshopplus.facade.PSPFacadeException;
import br.com.petshopplus.model.Login;
import br.com.petshopplus.safety.Restrito;
import br.com.petshopplus.safety.Session;

@Controller
public class IndexController {

	private final Validator validator;
	private final Result result;
	private final PSPFacade facade;
	
	protected IndexController() {
		this(null,null,null);
	}
	
	@Inject
	public IndexController(Validator validator, Result result, PSPFacade facade){
		this.validator = validator;
		this.result = result;
		this.facade = facade;
	}
	
	//@Restrito
	@Path("/home")
	public void home() {
	}

	@Path("/login")
	public void login(Login login) {
		try{
			facade.realizarLogin(login);
		}catch (PSPFacadeException e){
			validator.add(
				(Message) new ValidationMessage(e.getMessage(),
						"login.nomeUsuario"));
		}
		validator.onErrorUsePageOf(this).index();	
		result.redirectTo(this).home();
	}
	
	@Path("/")
	public void index() {	
	}
	
	//@Restrito
	@Path("/logout")
	public void logout() {
		Session.logout();
		result.redirectTo("/");
	}
	
}