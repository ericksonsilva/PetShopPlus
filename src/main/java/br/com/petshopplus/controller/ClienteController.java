package br.com.petshopplus.controller;


import java.util.List;

import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.model.Cliente;

public class ClienteController {
	private ClienteDao dao;
	public ClienteController() {
		dao = new ClienteDao();
	}
	
	public void adiciona(Cliente cliente){
		dao.salva(cliente);
	}
	
	public void atualiza(Cliente cliente){
		dao.atualiza(cliente);
	}
	
	public void apaga(Cliente cliente){
		dao.remove(cliente);
	}
	
	public Cliente busca(String cpf){
		return dao.carrega(cpf);
	}
	
	public Cliente busca(Cliente cliente){
		return dao.carrega(cliente);
	}
		
	public List<Cliente> lista(){
		return dao.lista();
	}
	
	public List<Cliente> lista(String nome){
		return dao.lista(nome);
	}

}
