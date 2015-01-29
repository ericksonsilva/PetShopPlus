package br.com.petshopplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.petshopplus.model.Login;
import br.com.petshopplus.persistence.HibernateUtil;

public class LoginDao {
	
	private final Session session;
	
	public LoginDao(){
		session = HibernateUtil.getInstance().getSession();
	}

	public void salva(Login login) {
		Transaction tx = session.beginTransaction();
		this.session.save(login);
		tx.commit();
	}
	
	public void atualiza(Login login) {
		Transaction tx = session.beginTransaction();
		this.session.update(login);
		tx.commit();
	}
	
	public void remove(Login login) {
		Transaction tx = session.beginTransaction();
		this.session.delete(login);
		tx.commit();
	}
	
	public Login carrega(int id) {
		return (Login) this.session.get(Login.class, id);
	}
	
	public Login carrega(Login login) {
		return (Login) session.createCriteria(Login.class)
		.add(Restrictions.eq("id", login.getId()))
		.uniqueResult();
	}
	
	public boolean existeLogin(Login login) {
		Login encontrado = (Login) session.createCriteria(Login.class)
				.add(Restrictions.eq("login", login.getLogin()))
				.uniqueResult();
				return encontrado != null;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Login> lista(String nome) {
		return this.session.createCriteria(Login.class)
		.add(Restrictions.eq("nome", nome)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Login> lista() {
		return this.session.createCriteria(Login.class).list();
	}
}
