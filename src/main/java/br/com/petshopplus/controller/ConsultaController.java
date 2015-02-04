package br.com.petshopplus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.dao.ConsultaDao;
import br.com.petshopplus.model.Consulta;

@Controller
public class ConsultaController {
	private ConsultaDao dao;
	private Result result;
	private Validator validator;

	
	protected ConsultaController() {
		this(null, null,null);
	}
	
	@Inject
	public ConsultaController(ConsultaDao dao,Result result,Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;

	}
	
	@Path("consulta/cadastro")
	public void formulario(){
	}

	@Path("consulta/adiciona")
	@Post
	public void adiciona(Consulta consulta){
	    validator.validate(consulta);
		validator.onErrorUsePageOf(this).formulario();
		dao.salva(consulta);
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
		return dao.lista();
	}
	
	public List<Consulta> lista(String nome){
		return dao.lista(nome);
	}
}
