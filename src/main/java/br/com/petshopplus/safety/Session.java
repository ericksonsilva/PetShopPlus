package br.com.petshopplus.safety;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.petshopplus.model.Funcionario;
import br.com.petshopplus.model.Login;

@SessionScoped
@Named("session")
public class Session implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6689661661871422801L;
	private static Login login;
	private static Funcionario funcionario;
	private static boolean logado;
	
	
	public static void setSession(Login l) {
		login = l;
		funcionario = l.getFuncionario();
		logado = true;
	}
	
	public static Login getLogin(){
		return login;
	}
	
	public static Funcionario getFuncionario(){
		return funcionario;
	}
		
	public static boolean isLogado() {
		return logado;
	}
	
	public static void logout() {
		login = null;
		funcionario = null;
		logado = false;
	}
}
