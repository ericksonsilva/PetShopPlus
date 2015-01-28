package br.com.petshopplus.controller;


import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.model.Cliente;

@Controller
public class ClienteController {
	private final ClienteDao dao;
	
	private final Result result;
	private final Validator validator;
	
	protected ClienteController() {
		this(null, null, null);
	}
	
	@Inject
	public ClienteController(ClienteDao dao,Result result,Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Path("cliente/cadastro")
	public void formulario(){
		
	}
	public void teste(){
	}
	@Path("cliente/adiciona")
	@Post
	public void adiciona(Cliente cliente){
		System.out.println("Nome: "+cliente.getNome()+"  Cidade: "+cliente.getCidade());
		dao.salva(cliente);
		this.result.redirectTo("/cliente/cadastro");
	}
	
	public void atualiza(Cliente cliente){
		dao.atualiza(cliente);
	}
	
	public void apaga(Cliente cliente){
		dao.remove(cliente);
	}
	
	public Cliente busca(String cpf){
		return dao.carrega(cpf);
	}
	
	public Cliente busca(Cliente cliente){
		return dao.carrega(cliente);
	}
		
	public List<Cliente> lista(){
		return dao.lista();
	}
	
	public List<Cliente> lista(String nome){
		return dao.lista(nome);
	}

}
