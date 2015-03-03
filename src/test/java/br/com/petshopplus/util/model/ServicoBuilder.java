package br.com.petshopplus.util.model;

import br.com.petshopplus.model.Servico;

public class ServicoBuilder {
	private final Servico servico = new Servico();
	
	public ServicoBuilder withNome(String nome) {
		servico.setNome(nome);
		return this;
	}
	
	public ServicoBuilder withValor(double valor) {
		servico.setValor(valor);
		return this;
	}
	
	public ServicoBuilder withDescricao(String descricao) {
		servico.setDescricao(descricao);
		return this;
	}
	
	public Servico build(){
		return servico;
	}
}
