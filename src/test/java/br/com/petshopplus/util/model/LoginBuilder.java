package br.com.petshopplus.util.model;

import br.com.petshopplus.model.Funcionario;
import br.com.petshopplus.model.Login;

public class LoginBuilder {
	private final Login login = new Login();
	
	public LoginBuilder withUsuario(String usuario) {
		login.setUsuario(usuario);
		return this;
	}
	
	public LoginBuilder withSenha(String senha) {
		login.setSenha(senha);
		return this;
	}

	public LoginBuilder withFuncionario(Funcionario funcionario) {
		login.setFuncionario(funcionario);
		return this;
	}
		
	public Login build() {
		return login;
	}
}
