package br.com.petshopplus.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.dao.AgendaDao;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.dao.ConsultaDao;
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Agenda;
import br.com.petshopplus.model.Consulta;

@Controller
public class AgendaController {
	private AgendaDao dao;
	private Result result;
	private ClienteDao clienteDao;
	private AnimalDao animalDao;

	private Validator validator;

	
	protected AgendaController() {
		this(null, null,null,null,null);
	}
	
	@Inject
	public AgendaController(AgendaDao dao,Result result,Validator validator,ClienteDao clienteDao,AnimalDao animalDao) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.clienteDao = clienteDao;
		this.animalDao = animalDao;

	}
	
	@Path("agenda/cadastro")
	@Get
	public void formulario(){
		this.result.include("clientes", clienteDao.lista());
		this.result.include("animais", animalDao.lista());
		
	}

	@Path("agenda/adiciona")
	@Post
	public void adiciona(Agenda agenda){
	    validator.validate(agenda);
		validator.onErrorUsePageOf(this).formulario();
		dao.salva(agenda);
		this.result.redirectTo("/agenda/cadastro");
	}	
	
	@Put
	public void atualiza(Agenda agenda){
		dao.atualiza(agenda);
		this.result.redirectTo("/marcados");
	}
	
	@Path("agenda/edita/{id}")
	public Agenda edita(int id){
		return dao.carrega(id);
	}
	
	@Path("agenda/remove/{id}")
	public void remove(int id){
		Agenda consulta = this.busca(id); 
		dao.remove(consulta);
		this.result.redirectTo("/marcados");
	}
	
	public Agenda busca(int id){
		return dao.carrega(id);
	}
	
	public Agenda busca(Agenda agenda){
		return dao.carrega(agenda);
	}
	
	@Path("marcados")	
	public List<Agenda> lista(){
		Date data = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataHoje = dateFormat.format(data);
		
		List<Agenda> agendados = dao.lista();
		List<Agenda> allagendados = new ArrayList<Agenda>();
		for (Agenda agenda : agendados) {
			if(agenda.isMarcado() && diamesano(dateFormat.format(agenda.getData())) >=diamesano(dataHoje)){
				allagendados.add(agenda);
			}
		}
		this.result.include("marcados", allagendados);
		return null;
	}
	
	
	@Path("desmarcados")	
	public List<Agenda> listaDesmarcados(){
		Date data = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataHoje = dateFormat.format(data);
		
		List<Agenda> agendados = dao.lista();
		List<Agenda> alldesmarcados = new ArrayList<Agenda>();
		for (Agenda agenda : agendados) {
			if(!agenda.isMarcado() && diamesano(dateFormat.format(agenda.getData())) >=diamesano(dataHoje)){
				alldesmarcados.add(agenda);
			}
		}
		this.result.include("desmarcados", alldesmarcados);
		return null;
	}
	public List<Agenda> lista(String nome){
		return dao.lista(nome);
	}
	
	private int diamesano(String data){
		String datas[] = data.split("/");
		String dt = datas[0]+datas[1]+datas[2];
		int anomesdia = Integer.parseInt(dt);
		return anomesdia;
	}
	
}
