package br.com.petshopplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Login_Funcionario")
public class Login {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private long id;
	
	private String login;
	private String senha;
	
	@OneToOne
	@JoinColumn(name="funcionario_id")
	private Funcionario func;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Funcionario getFunc() {
		return func;
	}


	public void setFunc(Funcionario func) {
		this.func = func;
	}


	public Login() {
		// TODO Auto-generated constructor stub
	}

}
