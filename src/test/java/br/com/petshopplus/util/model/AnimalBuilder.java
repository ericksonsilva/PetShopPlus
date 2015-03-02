package br.com.petshopplus.util.model;

import br.com.petshopplus.model.Animal;

public class AnimalBuilder {
	private final Animal animal = new Animal();
	
	public AnimalBuilder withNome(String nome) {
		animal.setNome(nome);
		return this;
	}
	
	public AnimalBuilder withSexo(String sexo) {
		animal.setSexo(sexo);
		return this;
	}
	
	public AnimalBuilder withRaca(String raca) {
		animal.setRaca(raca);
		return this;
	}
	
	public AnimalBuilder withEspecie(String especie) {
		animal.setEspecie(especie);
		return this;
	}
	
	public AnimalBuilder withPorte(String porte) {
		animal.setPorte(porte);
		return this;
	}
	public AnimalBuilder withIdade(String idade) {
		animal.setIdade(idade);
		return this;
	}
	public Animal build(){
		return animal;
	}
}
