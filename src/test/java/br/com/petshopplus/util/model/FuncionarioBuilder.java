package br.com.petshopplus.util.model;

import br.com.petshopplus.model.Funcionario;

public class FuncionarioBuilder {
	private final Funcionario funcionario = new Funcionario();
	
	public FuncionarioBuilder withCPF(String cpf) {
		funcionario.setCpf(cpf);
		return this;
	}
	
	public FuncionarioBuilder withNome(String nome) {
		funcionario.setNome(nome);
		return this;
	}

	public FuncionarioBuilder withTelefone(String telefone) {
		funcionario.setTelefone(telefone);
		return this;
	}
	
	public FuncionarioBuilder withRua(String rua) {
		funcionario.setRua(rua);
		return this;
	}
	
	public FuncionarioBuilder withComplemento(String complemento) {
		funcionario.setComplemento(complemento);
		return this;
	}
	
	public FuncionarioBuilder withBairro(String bairro) {
		funcionario.setBairro(bairro);
		return this;
	}
	
	public FuncionarioBuilder withCidade(String cidade) {
		funcionario.setCidade(cidade);
		return this;
	}
	
	public FuncionarioBuilder withEmail(String email) {
		funcionario.setEmail(email);
		return this;
	}
	
	public FuncionarioBuilder withFuncao(String funcao) {
		funcionario.setFuncao(funcao);
		return this;
	}
	
	public Funcionario build() {
		return funcionario;
	}
}
