package br.com.petshopplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.petshopplus.model.Cliente;
import br.com.petshopplus.persistence.HibernateUtil;

public class ClienteDao {

	private final Session session;
	
	public ClienteDao(){
		session = HibernateUtil.getInstance().getSession();
	}

	public void salva(Cliente cliente) {
		Transaction tx = session.beginTransaction();
		this.session.save(cliente);
		tx.commit();
	}
	
	public void atualiza(Cliente cliente) {
		Transaction tx = session.beginTransaction();
		this.session.update(cliente);
		tx.commit();
	}
	
	public void remove(Cliente cliente) {
		Transaction tx = session.beginTransaction();
		this.session.delete(cliente);
		tx.commit();
	}
	
	public Cliente carrega(String cpf) {
		return (Cliente) this.session.get(Cliente.class, cpf);
	}
	
	public Cliente carrega(Cliente cliente) {
		return (Cliente) session.createCriteria(Cliente.class)
		.add(Restrictions.eq("cpf", cliente.getCpf()))
		.uniqueResult();
	}
	
	public boolean existeCliente(Cliente cliente) {
		Cliente encontrado = (Cliente) session.createCriteria(Cliente.class)
				.add(Restrictions.eq("cpf", cliente.getCpf()))
				.uniqueResult();
				return encontrado != null;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Cliente> lista(String nome) {
		return this.session.createCriteria(Cliente.class)
		.add(Restrictions.eq("nome", nome)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> lista() {
		return this.session.createCriteria(Cliente.class).list();
	}

}