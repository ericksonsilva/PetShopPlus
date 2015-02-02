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
		if (animal.getNome() == null) {
			validator.add(new SimpleMessage("nome", "O campo nome é obrigatório. Tente novamente."));
			  }
		if (animal.getSexo() == null) {
			validator.add(new SimpleMessage("sexo", "O campo sexo é obrigatório. Tente novamente."));
			  }
		if (animal.getRaca() == null) {
			validator.add(new SimpleMessage("raca", "O campo raça é obrigatório. Tente novamente."));
			  }
		if (animal.getEspecie() == null) {
			validator.add(new SimpleMessage("especie", "O campo especie é obrigatório. Tente novamente."));
			  }
		if (animal.getIdade() == null) {
			validator.add(new SimpleMessage("idade", "O campo idade é obrigatório. Tente novamente."));
			  }
		if (animal.getPorte() == null) {
			validator.add(new SimpleMessage("porte", "O campo porte é obrigatório. Tente novamente."));
			  }	
		validator.onErrorUsePageOf(AnimalController.class).formulario();
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
