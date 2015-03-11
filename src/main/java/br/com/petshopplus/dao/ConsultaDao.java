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

	public void salva(Consulta agenda) {
		Transaction tx = session.beginTransaction();
		this.session.save(agenda);
		tx.commit();
	}
	
	public void atualiza(Consulta agenda) {
		System.out.println("animal: "+agenda.getAnimal().getNome()+" hora:"+agenda.getHora()
				+" id: "+agenda.getId()+" descricao: "+agenda.getDescricao()+
				" cliente: "+agenda.getCliente().getNome()
				);
		Transaction tx = session.beginTransaction();
		this.session.update(agenda);
		tx.commit();
	}
	
	public void remove(Consulta agenda) {
		Transaction tx = session.beginTransaction();
		this.session.delete(agenda);
		tx.commit();
	}
	
	public Consulta carrega(int id) {
		return (Consulta) this.session.get(Consulta.class, id);
	}
	
	public Consulta carrega(Consulta agenda) {
		return (Consulta) session.createCriteria(Consulta.class)
		.add(Restrictions.eq("id", agenda.getId()))
		.uniqueResult();
	}
	
	public boolean existeAgenda(Consulta agenda) {
		Consulta encontrado = (Consulta) session.createCriteria(Consulta.class)
				.add(Restrictions.eq("animal", agenda.getAnimal().getNome()))
				.add(Restrictions.eq("cliente", agenda.getCliente().getCpf()))
				.add(Restrictions.eq("cliente", agenda.getCliente().getNome()))
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
