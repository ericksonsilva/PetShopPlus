package br.com.petshopplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.com.petshopplus.model.Produto;
import br.com.petshopplus.persistence.HibernateUtil;

public class ProdutoDao {
private final Session session;
	
	public ProdutoDao(){
		session = HibernateUtil.getInstance().getSession();
	}

	public void salva(Produto produto) {
		Transaction tx = session.beginTransaction();
		this.session.save(produto);
		tx.commit();
	}
	
	public void atualiza(Produto produto) {
		Transaction tx = session.beginTransaction();
		this.session.update(produto);
		tx.commit();
	}
	
	public void remove(Produto produto) {
		Transaction tx = session.beginTransaction();
		this.session.delete(produto);
		tx.commit();
	}
	

	public Produto carrega(int id) {
		return (Produto) this.session.get(Produto.class, id);
	}
	public Produto carrega(Produto produto) {
		return (Produto) session.createCriteria(Produto.class)
		.add(Restrictions.eq("id", produto.getId()))
		.uniqueResult();
	}
	
	public boolean existeProduto(Produto produto) {
		Produto encontrado = (Produto) session.createCriteria(Produto.class)
				.add(Restrictions.eq("nome", produto.getNome()))
				.uniqueResult();
				return encontrado != null;
	}	
		
	
	@SuppressWarnings("unchecked")
	public List<Produto> lista(String nome) {
		return this.session.createCriteria(Produto.class)
		.add(Restrictions.eq("nome", nome)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> lista() {
		return this.session.createCriteria(Produto.class).list();
	}

}
