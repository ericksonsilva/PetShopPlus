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
		if (funcionario.getNome() == null || funcionario.getNome().length() < 3) {
			validator.add(new SimpleMessage("nome", "O campo nome é obrigatório e precisa ter mais de 3 letras. Tente novamente."));
			  }
		if (funcionario.getCpf() == null || funcionario.getCpf().length() != 11) {
			validator.add(new SimpleMessage("cpf", "O campo cpf é obrigatório e precisa ter 11 números. Tente novamente."));
			  }		
		if (funcionario.getTelefone() == null) {
			validator.add(new SimpleMessage("telefone", "O campo telefone é obrigatório. Tente novamente."));
			  }
		if (funcionario.getRua() == null) {
			validator.add(new SimpleMessage("rua", "O campo rua é obrigatório. Tente novamente."));
			  }
		if (funcionario.getBairro() == null) {
			validator.add(new SimpleMessage("bairro", "O campo bairro é obrigatório. Tente novamente."));
			  }
		if (funcionario.getComplemento() == null) {
			validator.add(new SimpleMessage("complemento", "O campo complemento é obrigatório. Tente novamente."));
			  }
		if (funcionario.getCidade() == null) {
			validator.add(new SimpleMessage("cidade", "O campo cidade é obrigatório. Tente novamente."));
			  }
		if (funcionario.getFuncao() == null) {
			validator.add(new SimpleMessage("funcao", "O campo função é obrigatório. Tente novamente."));
			  }	
		validator.onErrorUsePageOf(FuncionarioController.class).formulario();
		dao.salva(funcionario);
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

}
