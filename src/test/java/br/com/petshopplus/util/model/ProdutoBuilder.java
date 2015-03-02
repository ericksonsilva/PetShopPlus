package br.com.petshopplus.util.model;

import br.com.petshopplus.model.Produto;

public class ProdutoBuilder {
	private final Produto produto = new Produto();
	
	public ProdutoBuilder withNome(String nome){
		produto.setNome(nome);
		return this;
	}
	
	public ProdutoBuilder withDescricao(String descricao){
		produto.setDescricao(descricao);
		return this;
	}
	
	public ProdutoBuilder withPreco(double preco){
		produto.setPreco(preco);
		return this;
	}
	
	public Produto build(){
		return produto;
	}
}
