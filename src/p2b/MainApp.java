package p2b;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MainApp {
	
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws Exception{
		SessionFactory sessionFactory = null;
		
		final  StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try
		{
			Configuration configuration = new Configuration();
			sessionFactory = configuration.configure().buildSessionFactory(registry);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
		Session session = sessionFactory.openSession();
		session.getTransaction();
		
		//TODO: Run all queries. And create mysql tables.
		
		String hql = "**MYSQL STATEMENT**";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
	}

}
