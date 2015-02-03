package br.com.petshopplus.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Consultas")
public class Consulta {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	private Date data;
	@NotNull (message="Nome precisa ser preenchido")
	@Length(min=3, message="Descrição precisa ter mais de 3 letras")
	private String descricao;
	private List<Servico> servico;
	private Cliente cliente;
	private Animal animal;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Servico> getServico() {
		return servico;
	}
	
	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
}
