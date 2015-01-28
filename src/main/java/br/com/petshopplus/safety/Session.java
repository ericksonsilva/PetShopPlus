package br.com.petshopplus.safety;

import javax.enterprise.context.SessionScoped;

import br.com.petshopplus.model.Login;

@SessionScoped
public class Session {
	
	private static Login login;
	private static boolean logado;
	
	
	public static void setLogin(Login l) {
		login = l;
		logado = true;
	}
	
	public static void setSession(Login l) {
		login = l;
		logado = true;
	}
	
	public static Login getLogin(){
		return login;
	}
		
	public static boolean isLogado() {
		return logado;
	}
	
	public static void logout() {
		login = null;
		logado = false;
	}
}
