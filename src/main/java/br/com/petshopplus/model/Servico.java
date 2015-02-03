package br.com.petshopplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Servicos")
public class Servico {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	@NotNull (message="Nome precisa ser preenchido")
	@Length(min=3, message="Nome precisa ter mais de 3 letras")
		private String nome;
	@NotNull (message="Valor precisa ser preenchido")
		private float valor;
	@NotNull (message="Descrição precisa ser preenchido")
		private String descricao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
