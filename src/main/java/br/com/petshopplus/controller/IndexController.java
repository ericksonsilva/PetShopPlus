package br.com.petshopplus.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.petshopplus.dao.ConsultaDao;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.dao.LoginDao;
import br.com.petshopplus.dao.ProdutoDao;
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Login;
import br.com.petshopplus.safety.Restrito;
import br.com.petshopplus.safety.Session;

@Controller
public class IndexController {

	private final Result result;
	private final LoginDao loginDao;
	private final AnimalDao animalDao;
	private final ClienteDao clienteDao;
	private final ServicoDao servicoDao;
	private final ProdutoDao produtoDao;
	private final ConsultaDao agendaDao;
	
	protected IndexController() {
		this(null, null, null,  null, null, null, null);
	}
	
	@Inject
	public IndexController(Result result, LoginDao loginDao, AnimalDao animalDao, ClienteDao clienteDao, ServicoDao servicoDao, ProdutoDao produtoDao, ConsultaDao agendaDao){
		this.result = result;
		this.loginDao = loginDao;
		this.animalDao = animalDao;
		this.clienteDao = clienteDao;
		this.servicoDao = servicoDao;
		this.produtoDao = produtoDao;
		this.agendaDao = agendaDao;
	}
	
	@Path("/home")
	@Restrito
	public void home() {
		result.include("animais", animalDao.lista().size());
		result.include("clientes", clienteDao.lista().size());
		result.include("servicos", servicoDao.lista().size());
		result.include("produtos", produtoDao.lista().size());
		result.include("consultas", agendaDao.lista().size());
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