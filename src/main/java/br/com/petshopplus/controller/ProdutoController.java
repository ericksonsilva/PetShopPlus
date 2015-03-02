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
import br.com.petshopplus.dao.ProdutoDao;
import br.com.petshopplus.model.Produto;

@Controller
public class ProdutoController {
	private ProdutoDao dao;
	private Result result;
	private Validator validator;

	
	protected ProdutoController() {
		this(null, null,null);
	}
	
	@Inject
	public ProdutoController(ProdutoDao dao,Result result,Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;

	}
	
	@Path("produto/cadastro")
	public void formulario(){
	}

	@Path("produto/adiciona")
	@Post
	public void adiciona(Produto produto){
	    validarCampos(produto);
		validator.onErrorUsePageOf(this).formulario();
		result.include("success", "Incluído com sucesso.");
		dao.salva(produto);
		this.result.redirectTo("/produto/cadastro");
	}	
	
	@Put
	public void atualiza(Produto produto){
		dao.atualiza(produto);
		this.result.redirectTo("/produtos");
	}
	
	@Path("produto/edita/{id}")
	public Produto edita(int id){
		return dao.carrega(id);
	}
	
	@Path("produto/remove/{id}")
	public void remove(int id){
		Produto produto = this.busca(id); 
		dao.remove(produto);
		this.result.redirectTo("/produtos");
	}
	
	public Produto busca(int id){
		return dao.carrega(id);
	}
	
	public Produto busca(Produto produto){
		return dao.carrega(produto);
	}
	
	@Path("produtos")	
	public List<Produto> lista(){
		return dao.lista();
	}
	
	public List<Produto> lista(String nome){
		return dao.lista(nome);
	}
	
	public void validarCampos(Produto produto){
		
		if(produto.getNome()== null)validator.add(new SimpleMessage("nome", "O nome deve ser preenchido"));
		else if(produto.getNome().length() < 3) validator.add(new SimpleMessage("nome", "O nome deve conter mais de 3 letras"));
		
		validator.addIf(produto.getDescricao() == null, new SimpleMessage("descricao","A descrção deve ser preenchido"));
		validator.addIf(produto.getPreco() == 0.0, new SimpleMessage("valor","O preço deve ser preenchido"));


		validator.onErrorRedirectTo(this).formulario();
	}
}
