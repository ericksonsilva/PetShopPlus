package br.com.petshopplus.facade;

import javax.annotation.Resource;
import javax.inject.Inject;

import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.dao.FuncionarioDao;
import br.com.petshopplus.dao.LoginDao;
import br.com.petshopplus.model.Login;
import br.com.petshopplus.safety.Session;

@Resource
public class PSPFacade {

	private final LoginDao loginDao;
	private final AnimalDao animalDao;
	private final ClienteDao clienteDao;
	private final FuncionarioDao funcionarioDao;

	@Inject
	public PSPFacade(LoginDao loginDao, AnimalDao animalDao, ClienteDao clienteDao, FuncionarioDao funcionarioDao){
		this.loginDao = loginDao;
		this.animalDao = animalDao;
		this.clienteDao = clienteDao;
		this.funcionarioDao = funcionarioDao;
	}
	
	public void realizarLogin(Login l) throws PSPFacadeException{
		Login login = loginDao.carrega(l);
		if (login == null){
			throw new PSPFacadeException("Login e/ou senha inválidos");
		}
		Session.setSession(login);
	}

}
