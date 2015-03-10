package br.com.petshopplus.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.petshopplus.dao.LoginDao;
import br.com.petshopplus.model.Login;
import br.com.petshopplus.safety.Restrito;
import br.com.petshopplus.safety.Session;

@Controller
public class IndexController {

	private final Result result;
	private final LoginDao loginDao;
	
	protected IndexController() {
		this(null, null);
	}
	
	@Inject
	public IndexController(Result result, LoginDao loginDao){
		this.result = result;
		this.loginDao = loginDao;
	}
	
	@Path("/home")
	@Restrito
	public void home() {
	}

	@Path("/login")
	public void login(Login login) {
		Login l = loginDao.carrega(login);
		if (l == null){
			result.redirectTo(this).index();
		} else{
			Session.setSession(login);
			result.redirectTo(this).home();
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