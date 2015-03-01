package br.com.petshopplus.persistence;

import javax.enterprise.context.ApplicationScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
@ApplicationScoped
public class HibernateUtil {

  private static HibernateUtil instance = null;
  private static SessionFactory sessionFactory;
  
  private HibernateUtil() {
	}
  
	static {
		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException he) {
			System.err.println("Erro ao criar a conexao com o base de dados: " + he);
			throw new ExceptionInInitializerError(he);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session getSession(){
		return getSessionFactory().openSession();
	}

	public static HibernateUtil getInstance(){
        if(instance == null){
            instance = new HibernateUtil();
        }
        return instance;
    }
	
	public static void testConnection() throws Exception {
		getSessionFactory().openSession();
	}
}