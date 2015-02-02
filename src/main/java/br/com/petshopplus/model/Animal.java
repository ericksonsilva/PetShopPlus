package br.com.petshopplus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Animais")
public class Animal {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	@NotNull (message="Nome precisa ser preenchido")
	@Length(min=3, message="Nome precisa ter mais de 3 letras")
		private String nome;
	@NotNull (message="Sexo precisa ser preenchido")
		private String sexo;
	@NotNull (message="Raça precisa ser preenchido")
		private String raca;
	@NotNull (message="Espécie precisa ser preenchido")
		private String especie;
	@NotNull (message="Porte precisa ser preenchido")
		private String porte;
	@NotNull (message="Idade precisa ser preenchido")
		private String idade;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente dono;

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
	

}
