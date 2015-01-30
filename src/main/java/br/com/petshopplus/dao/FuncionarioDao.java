package br.com.petshopplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.petshopplus.model.Cliente;
import br.com.petshopplus.model.Funcionario;
import br.com.petshopplus.persistence.HibernateUtil;

public class FuncionarioDao {

	private final Session session;
	
	public FuncionarioDao(){
		session = HibernateUtil.getInstance().getSession();
	}

	public void salva(Funcionario funcionario) {
		Transaction tx = session.beginTransaction();
		this.session.save(funcionario);
		tx.commit();
	}
	
	public void atualiza(Funcionario funcionario) {
		Transaction tx = session.beginTransaction();
		this.session.update(funcionario);
		tx.commit();
	}
	
	public void remove(Funcionario funcionario) {
		Transaction tx = session.beginTransaction();
		this.session.delete(funcionario);
		tx.commit();
	}
	
	public Funcionario carrega(String cpf) {
		return (Funcionario) this.session.get(Funcionario.class, cpf);
	}
	public Funcionario carrega(int id) {
		return (Funcionario) this.session.get(Funcionario.class, id);
	}
	
	public Funcionario carrega(Funcionario funcionario) {
		return (Funcionario) session.createCriteria(Funcionario.class)
		.add(Restrictions.eq("cpf", funcionario.getCpf()))
		.uniqueResult();
	}
	
	public boolean existeFuncionario(Funcionario funcionario) {
		Funcionario encontrado = (Funcionario) session.createCriteria(Funcionario.class)
				.add(Restrictions.eq("cpf", funcionario.getCpf()))
				.uniqueResult();
				return encontrado != null;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> lista(String nome) {
		return this.session.createCriteria(Funcionario.class)
		.add(Restrictions.eq("nome", nome)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> lista() {
		return this.session.createCriteria(Funcionario.class).list();
	}

}
