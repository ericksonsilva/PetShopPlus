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
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.dao.ConsultaDao;
import br.com.petshopplus.dao.FuncionarioDao;
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Consulta;

@Controller
public class ConsultaController {
	private final ConsultaDao dao;
	private final Result result;
	private final ClienteDao clienteDao;
	private final AnimalDao animalDao;
	private final Validator validator;
	private final FuncionarioDao funcionarioDao;
	private final ServicoDao servicoDao;

	
	protected ConsultaController() {
		this(null, null,null,null,null, null,null);
	}
	
	@Inject
	public ConsultaController(ConsultaDao dao,Result result,Validator validator,ClienteDao clienteDao,AnimalDao animalDao, FuncionarioDao funcionarioDao,ServicoDao servicoDao) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.clienteDao = clienteDao;
		this.animalDao = animalDao;
		this.funcionarioDao = funcionarioDao;
		this.servicoDao = servicoDao;


	}
	
	@Path("consulta/cadastro")
	@Get
	public void formulario(){
		this.result.include("clientes", clienteDao.lista());
		this.result.include("animais", animalDao.lista());
		this.result.include("funcionarios", funcionarioDao.lista());
		this.result.include("servicos", servicoDao.lista());
		
		
	}

	@Path("consulta/adiciona")
	@Post
	public void adiciona(Consulta consulta){
		validarCampos(consulta);
		consulta.setMarcado(true);
		dao.salva(consulta);
		System.out.println("Veiooooooo");
		//result.include("success", "Incluído com sucesso.");
		this.result.redirectTo("/consulta/cadastro");
	}	
	
	@Put
	public void atualiza(Consulta consulta){
		consulta.setMarcado(true);
		dao.atualiza(consulta);
		this.result.redirectTo("/marcados");
	}
	
	@Path("consulta/edita/{id}")
	public Consulta edita(int id){
		return dao.carrega(id);
	}
	
	@Path("consulta/remove/{id}")
	public void remove(int id){
		Consulta consulta = this.busca(id);
		validator.check(consulta != null, new SimpleMessage("id", "Consulta não encontrado ou aconteceu algum erro na busca."));
		validator.onErrorUsePageOf(this).lista();
		result.include("success", "Excluído com sucesso.");
		dao.remove(consulta);
		this.result.redirectTo("/marcados");
	}
	@Path("consulta/desmarcar/{id}")
	public void desmarcar(int id){
		Consulta consulta = this.busca(id); 
		consulta.setMarcado(false);
		System.out.println("veio");
		this.dao.atualiza(consulta);
		
		this.result.redirectTo("/marcados");
	}
	
	@Path("consulta/remarcar/{id}")
	public void remarcar(int id){
		Consulta consulta = this.busca(id); 
		consulta.setMarcado(true);
		System.out.println("veio");
		this.dao.atualiza(consulta);
		
		this.result.redirectTo("/marcados");
	}
	@Path("consulta/concluirConsulta/{id}")
	public void concluirConsulta(int id){
		Consulta consulta = this.busca(id); 
		consulta.setMarcado(false);
		consulta.setAtendido(true);
		System.out.println("veio");
		this.dao.atualiza(consulta);
		
		this.result.redirectTo("/marcados");
	}
	public Consulta busca(int id){
		return dao.carrega(id);
	}
	
	public Consulta busca(Consulta consulta){
		return dao.carrega(consulta);
	}
	
	@Path("marcados")	
	public List<Consulta> lista(){
		Date data = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dataHoje = dateFormat.format(data);
		System.out.println("dataHoje: "+dataHoje);
		
		List<Consulta> agendados = dao.lista();
		List<Consulta> allagendados = new ArrayList<Consulta>();
		for (Consulta consulta : agendados) {
		
			if(consulta.isMarcado() && !consulta.isAtendido() && anoMesDia(dateFormat.format(consulta.getData())) >=anoMesDia(dataHoje)){
				allagendados.add(consulta);
			}
		}
		this.result.include("marcados", allagendados);
		return null;
	}
	
	
	@Path("desmarcados")	
	public List<Consulta> listaDesmarcados(){
		Date data = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dataHoje = dateFormat.format(data);

		List<Consulta> agendados = dao.lista();
		List<Consulta> alldesmarcados = new ArrayList<Consulta>();
		for (Consulta consulta : agendados) {
			if(!consulta.isMarcado() && !consulta.isAtendido() && anoMesDia(dateFormat.format(consulta.getData())) >=anoMesDia(dataHoje)){
				alldesmarcados.add(consulta);
			}
		}
		this.result.include("desmarcados", alldesmarcados);
		return null;
	}
	
	@Path("consultasrealizadas")	
	public List<Consulta> listaConsultasrealizadas(){
		List<Consulta> listConsultas = dao.lista();
		List<Consulta> consultas = new ArrayList<Consulta>();
		for (Consulta consulta : listConsultas) {
			if(consulta.isAtendido()){
				consultas.add(consulta);
			}
		}
		this.result.include("consultas", consultas);
		return null;
	}
	
	public List<Consulta> lista(String nome){
		return dao.lista(nome);
	}
	
	private int anoMesDia(String data){
		String datas[] = new String[8];
		datas=data.split("/");
		String dt = datas[0]+""+datas[1]+""+datas[2];
		int anomesdia = Integer.parseInt(dt);
		System.out.println("anomesdia: "+anomesdia);
		return anomesdia;
	}
	
	
	public void validarCampos(Consulta consulta){		
		validator.addIf(consulta.getDescricao() == null, new SimpleMessage("descricao","A descrição deve ser preenchida"));
		validator.addIf(consulta.getHora() == null, new SimpleMessage("hora","A hora deve ser preenchida"));
		

		validator.onErrorRedirectTo(this).formulario();
	}
}
