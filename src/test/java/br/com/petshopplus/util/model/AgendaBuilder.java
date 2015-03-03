package br.com.petshopplus.util.model;

import java.util.Date;
import java.util.List;

import br.com.petshopplus.model.Agenda;
import br.com.petshopplus.model.Animal;
import br.com.petshopplus.model.Cliente;
import br.com.petshopplus.model.Funcionario;

public class AgendaBuilder {
	private final Agenda agenda = new Agenda();
	
	public AgendaBuilder withData(Date data) {
		agenda.setData(data);
		return this;
	}
	
	public AgendaBuilder withDescricao(String descricao) {
		agenda.setDescricao(descricao);
		return this;
	}

	public AgendaBuilder withHora(String hora) {
		agenda.setHora(hora);
		return this;
	}
	
	public AgendaBuilder withMarcado(boolean marcado) {
		agenda.setMarcado(marcado);
		return this;
	}
	
	
	
	public AgendaBuilder withAnimais(Animal animais) {
		agenda.setAnimal(animais);
		return this;
	}
	public AgendaBuilder withFuncionarios(Funcionario funcionario) {
		agenda.setFuncionario(funcionario);
		return this;
	}
	public AgendaBuilder withClientes(Cliente cliente) {
		agenda.setCliente(cliente);
		return this;
	}
	
	public Agenda build() {
		return agenda;
	}
}
