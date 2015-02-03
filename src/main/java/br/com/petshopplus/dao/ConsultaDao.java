package br.com.petshopplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.petshopplus.model.Consulta;
import br.com.petshopplus.persistence.HibernateUtil;

public class ConsultaDao {
	
	private final Session session;
	
	public ConsultaDao(){
		session = HibernateUtil.getInstance().getSession();
	}

	public void salva(Consulta consulta) {
		Transaction tx = session.beginTransaction();
		this.session.save(consulta);
		tx.commit();
	}
	
	public void atualiza(Consulta consulta) {
		Transaction tx = session.beginTransaction();
		this.session.update(consulta);
		tx.commit();
	}
	
	public void remove(Consulta consulta) {
		Transaction tx = session.beginTransaction();
		this.session.delete(consulta);
		tx.commit();
	}
	
	public Consulta carrega(int id) {
		return (Consulta) this.session.get(Consulta.class, id);
	}
	
	public Consulta carrega(Consulta consulta) {
		return (Consulta) session.createCriteria(Consulta.class)
		.add(Restrictions.eq("id", consulta.getId()))
		.uniqueResult();
	}
	
	public boolean existeConsulta(Consulta consulta) {
		Consulta encontrado = (Consulta) session.createCriteria(Consulta.class)
				.add(Restrictions.eq("animal", consulta.getAnimal().getNome()))
				.add(Restrictions.eq("cliente", consulta.getCliente().getCpf()))
				.add(Restrictions.eq("cliente", consulta.getCliente().getNome()))
				.uniqueResult();
				return encontrado != null;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Consulta> lista(String nome) {
		return this.session.createCriteria(Consulta.class)
		.add(Restrictions.eq("nome", nome)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> lista() {
		return this.session.createCriteria(Consulta.class).list();
	}
}
