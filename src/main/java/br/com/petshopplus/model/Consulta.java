package br.com.petshopplus.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Consultas")
public class Consulta {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	private Date data;
	private String descricao;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@ElementCollection(targetClass=Servico.class)
	@Column(name = "SERVICO_ID")
	private List<Servico> servico;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="animal")
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
