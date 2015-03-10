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
import br.com.petshopplus.dao.LoginDao;
import br.com.petshopplus.model.Funcionario;
import br.com.petshopplus.model.Login;

@Controller
public class FuncionarioController {
	private final FuncionarioDao funcDao;
	private final LoginDao loginDao;
	private final Result result;
	private final Validator validator;
	
	protected FuncionarioController() {
		this(null, null, null, null);
	}
	
	@Inject
	public FuncionarioController(FuncionarioDao funcDao, LoginDao loginDao,Result result,Validator validator) {
		this.funcDao = funcDao;
		this.loginDao = loginDao;
		this.result = result;
		this.validator = validator;
	}
	
	@Path("funcionario/cadastro")
	public void formulario(){}

	@Path("funcinario/adiciona")
	@Post
	public void adiciona(Funcionario funcionario, Login login){
	    validarCampos(funcionario);
		funcDao.salva(funcionario);
		login.setFuncionario(funcionario);
		loginDao.salva(login);
		result.include("success", "Incluído com sucesso.");
		this.result.redirectTo("/funcionario/cadastro");
	}	
	
	@Put
	public void atualiza(Funcionario funcionario){
		funcDao.atualiza(funcionario);
		this.result.redirectTo("/funcionarios");
	}
	
	@Path("funcionario/edita/{id}")
	public Funcionario edita(int id){
		return funcDao.carrega(id);
	}
	
	@Path("funcionario/remove/{id}")
	public void remove(int id){
		Funcionario funcionario = this.busca(id); 
		funcDao.remove(funcionario);
		this.result.redirectTo("/funcionarios");
	}
	
	public Funcionario busca(int id){
		return funcDao.carrega(id);
	}
		
	public Funcionario busca(String cpf){
		return funcDao.carrega(cpf);
	}
	
	public Funcionario busca(Funcionario funcionario){
		return funcDao.carrega(funcionario);
	}
	
	@Path("funcionarios")	
	public List<Funcionario> lista(){
		return funcDao.lista();
	}
	
	public List<Funcionario> lista(String nome){
		return funcDao.lista(nome);
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
