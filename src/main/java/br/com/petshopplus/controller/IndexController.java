package br.com.petshopplus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.dao.ConsultaDao;
import br.com.petshopplus.dao.LoginDao;
import br.com.petshopplus.dao.ProdutoDao;
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Consulta;
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
		result.include("registros", String.valueOf(animalDao.lista().size()+"_"+clienteDao.lista().size()+"_"+servicoDao.lista().size()+"_"+produtoDao.lista().size()));
		
		int consultasMarcadas = 0;
		int consultasDesmarcadas = 0;
		int consultasAtendidas = 0;
		for(Consulta consulta : agendaDao.lista()){
			if (consulta.isAtendido()){
				consultasAtendidas++;
			} else if (consulta.isMarcado()){
				consultasMarcadas++;
			} else{
				consultasDesmarcadas++;
			}
		}
		result.include("consultas", String.valueOf(consultasMarcadas+"_"+consultasDesmarcadas+"_"+consultasAtendidas));
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