package br.com.petshopplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.petshopplus.model.Agenda;
import br.com.petshopplus.model.Consulta;
import br.com.petshopplus.persistence.HibernateUtil;

public class AgendaDao {
	
	private final Session session;
	
	public AgendaDao(){
		session = HibernateUtil.getInstance().getSession();
	}

	public void salva(Agenda agenda) {
		Transaction tx = session.beginTransaction();
		this.session.save(agenda);
		tx.commit();
	}
	
	public void atualiza(Agenda agenda) {
		System.out.println("animal: "+agenda.getAnimal().getNome()+" hora:"+agenda.getHora()
				+" id: "+agenda.getId()+" descricao: "+agenda.getDescricao()+
				" cliente: "+agenda.getCliente().getNome()
				);
		Transaction tx = session.beginTransaction();
		this.session.update(agenda);
		tx.commit();
	}
	
	public void remove(Agenda agenda) {
		Transaction tx = session.beginTransaction();
		this.session.delete(agenda);
		tx.commit();
	}
	
	public Agenda carrega(int id) {
		return (Agenda) this.session.get(Agenda.class, id);
	}
	
	public Agenda carrega(Agenda agenda) {
		return (Agenda) session.createCriteria(Agenda.class)
		.add(Restrictions.eq("id", agenda.getId()))
		.uniqueResult();
	}
	
	public boolean existeAgenda(Agenda agenda) {
		Agenda encontrado = (Agenda) session.createCriteria(Agenda.class)
				.add(Restrictions.eq("animal", agenda.getAnimal().getNome()))
				.add(Restrictions.eq("cliente", agenda.getCliente().getCpf()))
				.add(Restrictions.eq("cliente", agenda.getCliente().getNome()))
				.uniqueResult();
				return encontrado != null;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Agenda> lista(String nome) {
		return this.session.createCriteria(Agenda.class)
		.add(Restrictions.eq("nome", nome)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agenda> lista() {
		return this.session.createCriteria(Agenda.class).list();
	}
}
