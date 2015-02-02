package br.com.petshopplus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.model.Animal;

@Controller
public class AnimalController {
	private AnimalDao dao;
	private ClienteDao clienteDao;
	private Result result;
	private Validator validator;

	
	protected AnimalController() {
		this(null, null,null,null);
	}
	
	@Inject
	public AnimalController(AnimalDao dao,ClienteDao clienteDao,Result result,Validator validator) {
		this.dao = dao;
		this.result = result;
		this.clienteDao = clienteDao;
		this.validator = validator;

	}
	
	@Path("animal/cadastro")
	@Get
	public void formulario(){
		this.result.include("clientes", clienteDao.lista());
		
	}
	public void adiciona(Animal animal){
	    validator.validate(animal);
		validator.onErrorUsePageOf(this).formulario();
		dao.salva(animal);
		this.result.redirectTo("/animal/cadastro");
	}
	
	public void atualiza(Animal animal){
		dao.atualiza(animal);
		this.result.redirectTo("/animais");
	}
	
	@Path("animal/edita/{id}")
	@Get
	public Animal editar(int id){
		return dao.carrega(id);
		
	}
	
	@Path("animal/remove/{id}")
	public void remove(Animal animal){
		dao.remove(animal);
	}
	
	public Animal busca(int registro){
		return dao.carrega(registro);
	}
	
	public Animal busca(Animal animal){
		return dao.carrega(animal);
	}
	
	@Path("animais")
	public List<Animal> lista(){
		result.include("animais", dao.lista());
		return null;
	}
	
	public List<Animal> lista(String nome){
		return dao.lista(nome);
	}
	
}
