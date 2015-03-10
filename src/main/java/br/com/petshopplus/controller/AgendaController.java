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
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.dao.AgendaDao;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.dao.FuncionarioDao;
import br.com.petshopplus.model.Agenda;
import br.com.petshopplus.model.Cliente;

@Controller
public class AgendaController {
	private final AgendaDao dao;
	private final Result result;
	private final ClienteDao clienteDao;
	private final AnimalDao animalDao;
	private final Validator validator;
	private final FuncionarioDao funcionarioDao;

	
	protected AgendaController() {
		this(null, null,null,null,null, null);
	}
	
	@Inject
	public AgendaController(AgendaDao dao,Result result,Validator validator,ClienteDao clienteDao,AnimalDao animalDao, FuncionarioDao funcionarioDao) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.clienteDao = clienteDao;
		this.animalDao = animalDao;
		this.funcionarioDao = funcionarioDao;


	}
	
	@Path("agenda/cadastro")
	@Get
	public void formulario(){
		this.result.include("clientes", clienteDao.lista());
		this.result.include("animais", animalDao.lista());
		this.result.include("funcionarios", funcionarioDao.lista());
		
		
	}

	@Path("agenda/adiciona")
	@Post
	public void adiciona(Agenda agenda){
		validarCampos(agenda);
		agenda.setMarcado(true);
		dao.salva(agenda);
		result.include("success", "Incluído com sucesso.");
		this.result.redirectTo("/agenda/cadastro");
	}	
	
	@Put
	public void atualiza(Agenda agenda){
		agenda.setMarcado(true);
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
		validator.check(consulta != null, new SimpleMessage("id", "Consulta não encontrado ou aconteceu algum erro na busca."));
		validator.onErrorUsePageOf(this).lista();
		result.include("success", "Excluído com sucesso.");
		dao.remove(consulta);
		this.result.redirectTo("/marcados");
	}
	@Path("agenda/desmarcar/{id}")
	public void desmarcar(int id){
		Agenda agenda = this.busca(id); 
		agenda.setMarcado(false);
		System.out.println("veio");
		this.dao.atualiza(agenda);
		
		this.result.redirectTo("/marcados");
	}
	
	@Path("agenda/remarcar/{id}")
	public void remarcar(int id){
		Agenda agenda = this.busca(id); 
		agenda.setMarcado(true);
		System.out.println("veio");
		this.dao.atualiza(agenda);
		
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dataHoje = dateFormat.format(data);
		System.out.println("dataHoje: "+dataHoje);
		
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
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
		String datas[] = new String[8];
		datas=data.split("/");
		String dt = datas[0]+""+datas[1]+""+datas[2];
		int anomesdia = Integer.parseInt(dt);
		System.out.println("anomesdia: "+anomesdia);
		return anomesdia;
	}
	
	
	public void validarCampos(Agenda agenda){		
		validator.addIf(agenda.getDescricao() == null, new SimpleMessage("descricao","A descrição deve ser preenchida"));
		validator.addIf(agenda.getHora() == null, new SimpleMessage("hora","A hora deve ser preenchida"));
		

		validator.onErrorRedirectTo(this).formulario();
	}
}
