package br.com.petshopplus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.model.Animal;

@Controller
public class AnimalController {
	private AnimalDao dao;
	
	@Inject
	public AnimalController(AnimalDao dao) {
		this.dao = dao;
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
