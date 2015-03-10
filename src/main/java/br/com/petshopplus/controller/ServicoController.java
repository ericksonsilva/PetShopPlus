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
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Servico;

@Controller
public class ServicoController {
	private ServicoDao dao;
	private Result result;
	private Validator validator;

	
	protected ServicoController() {
		this(null, null,null);
	}
	
	@Inject
	public ServicoController(ServicoDao dao,Result result,Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;

	}
	
	@Path("servico/cadastro")
	public void formulario(){
	}

	@Path("servico/adiciona")
	@Post
	public void adiciona(Servico servico){
		validarCampos(servico);
		dao.salva(servico);
		result.include("success", "Incluído com sucesso.");
		this.result.redirectTo("/servico/cadastro");
	}	
	
	@Put
	public void atualiza(Servico servico){
		dao.atualiza(servico);
		this.result.redirectTo("/servicos");
	}
	
	@Path("servico/edita/{id}")
	public Servico edita(int id){
		return dao.carrega(id);
	}
	
	@Path("servico/remove/{id}")
	public void remove(int id){
		Servico servico = this.busca(id); 
		dao.remove(servico);
		this.result.redirectTo("/servicos");
	}
	
	public Servico busca(int id){
		return dao.carrega(id);
	}
	
	public Servico busca(Servico servico){
		return dao.carrega(servico);
	}
	
	@Path("servicos")	
	public List<Servico> lista(){
		return dao.lista();
	}
	
	public List<Servico> lista(String nome){
		return dao.lista(nome);
	}
	
public void validarCampos(Servico servico){
		
		if(servico.getNome()== null)validator.add(new SimpleMessage("nome", "O nome deve ser preenchido"));
		else if(servico.getNome().length() < 3) validator.add(new SimpleMessage("nome", "O nome deve conter mais de 3 letras"));
		
		validator.addIf(servico.getDescricao() == null, new SimpleMessage("descricao","A descrção deve ser preenchido"));
		validator.addIf(servico.getValor() == 0, new SimpleMessage("valor","O valor deve ser preenchido"));

		validator.onErrorRedirectTo(this).formulario();

}
}
