	package br.com.petshopplus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Funcionarios")
public class Funcionario {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	
	private String cpf;
	private String nome;
	private String telefone;
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String email;
	private String funcao;
	
	@OneToOne(mappedBy = "funcionario", targetEntity = Login.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Login login;
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

}

