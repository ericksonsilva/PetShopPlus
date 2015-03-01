package br.com.petshopplus.controller;

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
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Animal;
import br.com.petshopplus.model.Consulta;

@Controller
public class ConsultaController {
	private ConsultaDao dao;
	private Result result;
	private ClienteDao clienteDao;
	private AnimalDao animalDao;
	private ServicoDao servicoDao;

	private Validator validator;

	
	protected ConsultaController() {
		this(null, null,null,null,null,null);
	}
	
	@Inject
	public ConsultaController(ConsultaDao dao,Result result,Validator validator,ClienteDao clienteDao,AnimalDao animalDao,ServicoDao servicoDao) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.servicoDao = servicoDao;
		this.clienteDao = clienteDao;
		this.animalDao = animalDao;

	}
	
	@Path("consulta/cadastro")
	@Get
	public void formulario(){
		this.result.include("clientes", clienteDao.lista());
		this.result.include("servicos", servicoDao.lista());
		this.result.include("animais", animalDao.lista());
		
	}

	@Path("consulta/adiciona")
	@Post
	public void adiciona(Consulta consulta){
		System.out.println("Descrição: "+consulta.getDescricao()+" Animal: "+consulta.getAnimal().getId()
				+" Cliente: "+consulta.getCliente().getId()+" Data: "+consulta.getData()+" Servico: "+consulta.getServico().getId());
	    validarCampos(consulta);
		dao.salva(consulta);
		result.include("success", "Incluído com sucesso.");
		this.result.redirectTo("/consulta/cadastro");
	}	
	
	@Put
	public void atualiza(Consulta consulta){
		dao.atualiza(consulta);
		this.result.redirectTo("/consultas");
	}
	
	@Path("consulta/edita/{id}")
	public Consulta edita(int id){
		return dao.carrega(id);
	}
	
	@Path("consulta/remove/{id}")
	public void remove(int id){
		Consulta consulta = this.busca(id); 
		dao.remove(consulta);
		this.result.redirectTo("/consultas");
	}
	
	public Consulta busca(int id){
		return dao.carrega(id);
	}
	
	public Consulta busca(Consulta consulta){
		return dao.carrega(consulta);
	}
	
	@Path("consultas")	
	public List<Consulta> lista(){
		this.result.include("consultas", dao.lista());
		return null;
	}
	
	public List<Consulta> lista(String nome){
		return dao.lista(nome);
	}
	
public void validarCampos(Consulta consulta){
				
		validator.addIf(consulta.getDescricao() == null, new SimpleMessage("descricao","A descrição deve ser preenchida"));
		validator.addIf(consulta.getData() == null, new SimpleMessage("data","A data deve ser preenchida"));		

		validator.onErrorRedirectTo(this).formulario();
	}
}
