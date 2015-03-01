package br.com.petshopplus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
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
	public void formulario(){}
	
	public void teste(){
	}
	@Path("cliente/adiciona")
	@Post
	public void adiciona(Cliente cliente){
		validarCampos(cliente);
		dao.salva(cliente);
		result.include("success", "Incluído com sucesso.");
		this.result.redirectTo("/cliente/cadastro");
	}
	
	public void atualiza(Cliente cliente){
		dao.atualiza(cliente);
		this.result.redirectTo("/clientes");
	}
	
	@Path("cliente/edita/{id}")
	public Cliente edita(int id){		
		return dao.carrega(id);
	}
	
	@Path("cliente/remove/{id}")
	public void remove(int id){
		Cliente cliente = this.busca(id); 
		dao.remove(cliente);
		this.result.redirectTo("/clientes");
	}
	
	public Cliente busca(int id){
		return dao.carrega(id);
	}
	
	public Cliente busca(String cpf){
		return dao.carrega(cpf);
	}
	
	public Cliente busca(Cliente cliente){
		return dao.carrega(cliente);
	}
	
	@Path("clientes")
	public List<Cliente> lista(){
		return dao.lista();
	}
	
	public List<Cliente> lista(String nome){
		return dao.lista(nome);
	}

	public void validarCampos(Cliente cliente){
		if(cliente.getCpf()== null)	validator.add(new SimpleMessage("cpf", "O cpf deve ser preenchido"));
		else if(cliente.getCpf().length() != 11) validator.add(new SimpleMessage("cpf", "O cpf deve conter 11 dígitos"));

		if(cliente.getNome()== null)validator.add(new SimpleMessage("nome", "O nome deve ser preenchido"));
		else if(cliente.getNome().length() < 3) validator.add(new SimpleMessage("nome", "O nome deve conter mais de 3 letras"));
		
		validator.addIf(cliente.getTelefone() == null, new SimpleMessage("telefone","O telefone deve ser preenchido"));
		validator.addIf(cliente.getRua() == null, new SimpleMessage("rua","Rua deve ser preenchido"));
		validator.addIf(cliente.getComplemento() == null, new SimpleMessage("complemento","O complemento deve ser preenchido"));
		validator.addIf(cliente.getBairro() == null, new SimpleMessage("bairro","O Bairro deve ser preenchido"));
		validator.addIf(cliente.getCidade() == null, new SimpleMessage("cidade","A cidade deve ser preenchido"));
		validator.addIf(cliente.getCep() == null, new SimpleMessage("cep","O cep deve ser preenchido"));

		validator.onErrorRedirectTo(this).formulario();
	}
}
