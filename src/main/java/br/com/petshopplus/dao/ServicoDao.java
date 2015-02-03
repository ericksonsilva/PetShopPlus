package br.com.petshopplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.petshopplus.model.Servico;
import br.com.petshopplus.persistence.HibernateUtil;

public class ServicoDao {
	
	private final Session session;
	
	public ServicoDao(){
		session = HibernateUtil.getInstance().getSession();
	}

	public void salva(Servico servico) {
		Transaction tx = session.beginTransaction();
		this.session.save(servico);
		tx.commit();
	}
	
	public void atualiza(Servico servico) {
		Transaction tx = session.beginTransaction();
		this.session.update(servico);
		tx.commit();
	}
	
	public void remove(Servico servico) {
		Transaction tx = session.beginTransaction();
		this.session.delete(servico);
		tx.commit();
	}
	
	public Servico carrega(int id) {
		return (Servico) this.session.get(Servico.class, id);
	}
	
	public Servico carrega(Servico servico) {
		return (Servico) session.createCriteria(Servico.class)
		.add(Restrictions.eq("id", servico.getId()))
		.uniqueResult();
	}
	
	public boolean existeServico(Servico servico) {
		Servico encontrado = (Servico) session.createCriteria(Servico.class)
				.add(Restrictions.eq("nome", servico.getNome()))
				.uniqueResult();
				return encontrado != null;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Servico> lista(String nome) {
		return this.session.createCriteria(Servico.class)
		.add(Restrictions.eq("nome", nome)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> lista() {
		return this.session.createCriteria(Servico.class).list();
	}
}
