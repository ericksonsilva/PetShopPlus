package br.com.petshopplus.util.model;

import java.util.List;

import br.com.petshopplus.model.Animal;
import br.com.petshopplus.model.Cliente;

public class ClienteBuilder {
	private final Cliente cliente = new Cliente();
	
	public ClienteBuilder withCPF(String cpf) {
		cliente.setCpf(cpf);
		return this;
	}
	
	public ClienteBuilder withNome(String nome) {
		cliente.setNome(nome);
		return this;
	}

	public ClienteBuilder withTelefone(String telefone) {
		cliente.setTelefone(telefone);
		return this;
	}
	
	public ClienteBuilder withRua(String rua) {
		cliente.setRua(rua);
		return this;
	}
	
	public ClienteBuilder withComplemento(String complemento) {
		cliente.setComplemento(complemento);
		return this;
	}
	
	public ClienteBuilder withBairro(String bairro) {
		cliente.setBairro(bairro);
		return this;
	}
	
	public ClienteBuilder withCidade(String cidade) {
		cliente.setCidade(cidade);
		return this;
	}
	
	public ClienteBuilder withCep(String cep) {
		cliente.setCep(cep);
		return this;
	}
	
	public ClienteBuilder withEmail(String email) {
		cliente.setEmail(email);
		return this;
	}
	
	public ClienteBuilder withAnimais(List<Animal> animais) {
		cliente.setAnimais(animais);
		return this;
	}
	
	public Cliente build() {
		return cliente;
	}
}
