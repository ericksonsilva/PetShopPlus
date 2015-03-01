package br.com.petshopplus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.dao.FuncionarioDao;
import br.com.petshopplus.model.Funcionario;

@Controller
public class FuncionarioController {
	private final FuncionarioDao dao;
	private final Result result;
	private final Validator validator;
	
	protected FuncionarioController() {
		this(null, null, null);
	}
	
	@Inject
	public FuncionarioController(FuncionarioDao dao,Result result,Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Path("funcionario/cadastro")
	public void formulario(){}

	@Path("funcinario/adiciona")
	@Post
	public void adiciona(Funcionario funcionario){
	    validarCampos(funcionario);
		dao.salva(funcionario);
		result.include("success", "Incluído com sucesso.");
		this.result.redirectTo("/funcionario/cadastro");
	}	
	
	@Put
	public void atualiza(Funcionario funcionario){
		dao.atualiza(funcionario);
		this.result.redirectTo("/funcionarios");
	}
	
	@Path("funcionario/edita/{id}")
	public Funcionario edita(int id){
		return dao.carrega(id);
	}
	
	@Path("funcionario/remove/{id}")
	public void remove(int id){
		Funcionario funcionario = this.busca(id); 
		dao.remove(funcionario);
		this.result.redirectTo("/funcionarios");
	}
	
	public Funcionario busca(int id){
		return dao.carrega(id);
	}
		
	public Funcionario busca(String cpf){
		return dao.carrega(cpf);
	}
	
	public Funcionario busca(Funcionario funcionario){
		return dao.carrega(funcionario);
	}
	
	@Path("funcionarios")	
	public List<Funcionario> lista(){
		return dao.lista();
	}
	
	public List<Funcionario> lista(String nome){
		return dao.lista(nome);
	}

	public void validarCampos(Funcionario funcionario){
		if(funcionario.getCpf()== null)	validator.add(new SimpleMessage("cpf", "O cpf deve ser preenchido"));
		else if(funcionario.getCpf().length() != 11) validator.add(new SimpleMessage("cpf", "O cpf deve conter 11 dígitos"));

		if(funcionario.getNome()== null)validator.add(new SimpleMessage("nome", "O nome deve ser preenchido"));
		else if(funcionario.getNome().length() < 3) validator.add(new SimpleMessage("nome", "O nome deve conter mais de 3 letras"));
		
		validator.addIf(funcionario.getTelefone() == null, new SimpleMessage("telefone","O telefone deve ser preenchido"));
		validator.addIf(funcionario.getRua() == null, new SimpleMessage("rua","Rua deve ser preenchido"));
		validator.addIf(funcionario.getComplemento() == null, new SimpleMessage("complemento","O complemento deve ser preenchido"));
		validator.addIf(funcionario.getBairro() == null, new SimpleMessage("bairro","O Bairro deve ser preenchido"));
		validator.addIf(funcionario.getCidade() == null, new SimpleMessage("cidade","A cidade deve ser preenchido"));

		validator.onErrorRedirectTo(this).formulario();
	}
}
