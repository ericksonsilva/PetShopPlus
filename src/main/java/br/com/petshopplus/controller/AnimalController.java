package br.com.petshopplus.controller;

import java.util.List;

import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.model.Animal;

public class AnimalController {
	private AnimalDao dao;
	
	public AnimalController() {
		dao = new AnimalDao();
	}
	
	public void adiciona(Animal animal){
		dao.salva(animal);
	}
	
	public void atualiza(Animal animal){
		dao.atualiza(animal);
	}
	
	public void apaga(Animal animal){
		dao.remove(animal);
	}
	
	public Animal busca(int registro){
		return dao.carrega(registro);
	}
	
	public Animal busca(Animal animal){
		return dao.carrega(animal);
	}
		
	public List<Animal> lista(){
		return dao.lista();
	}
	
	public List<Animal> lista(String nome){
		return dao.lista(nome);
	}
	
}
