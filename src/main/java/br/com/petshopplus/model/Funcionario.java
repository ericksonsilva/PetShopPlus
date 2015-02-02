	package br.com.petshopplus.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Funcionarios")
public class Funcionario {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	
	@NotNull (message="Cpf precisa ser preenchido")
	@Length(min=11,message=" Cpf deve ter 11 dígitos")
		private String cpf;
	@NotNull (message="Nome precisa ser preenchido")
	@Length(min=3, message="Nome precisa ter mais de 3 letras")
		private String nome;
	@NotNull (message="Telefone precisa ser preenchido")
		private String telefone;
	@NotNull (message="Rua precisa ser preenchido")
		private String rua;
	@NotNull (message="Complemento precisa ser preenchido")
		private String complemento;
	@NotNull (message="Bairro precisa ser preenchido")
		private String bairro;
	@NotNull (message="Cidade precisa ser preenchido")
		private String cidade;
	private String email;
	@NotNull (message="Função precisa ser preenchido")
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

