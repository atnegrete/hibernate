package p2b;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MainApp {
	//You may just use @SuppressWarnings(“unchecked”) to suppress unchecked warnings in Java.
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws Exception
	{
      SessionFactory sessionFactory = null;
		
		//Configure setting
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
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
		
		// Item 1 
		String hql = "select p from " + Person.class.getName() + " p";
		Query query = session.createQuery(hql);
		List<Person> person_list = query.list();
		for(Person p : person_list){
			System.out.println("Name: " + p.getName() + " - " + "Address: " + p.getAddress());
		}
		
		// Item 2 
		Query query2 = session.createQuery("select s from " + Student.class.getName() + " s");
		List<Student> student_list = query2.list();
		for(Student s : student_list){
			System.out.println("Student Name: " + s.getName() );
		}
		 
		// Item 3
		for(Student s : student_list){
			System.out.println("Student Name: " + s.getName() + " - Mentor Name: " + s.getMentor().getName());
		}
		
		// Item 4
		Query query3 = session.createQuery("select f from " + Faculty.class.getName() + " f");
		List<Faculty> faculty_list = query3.list();
		for(Faculty f : faculty_list){
			if(f.getName().equals("Min Tuyet")){
				for(Student s : f.getMentored_students()){
					System.out.println(s.getName() + " is mentored by Min Tuyet.");
				}
			}
		}
		
		// Item 5
		for(Faculty f : faculty_list){
			if(f.getName().equals("Min Tuyet")){
				double sum = 0;
				for(Student s : f.getMentored_students()){
					sum += s.getGpa();
				}
				System.out.println("Average GPA of Min Tuyet students : " + (sum/(f.getMentored_students().size())));
			}
		}
		
		// Item 6
		String id = "480293439";
		String name = "Briggs Jason";
		String address = "215, North Hyland Avenue";
        Date dob = new Date(1975-01-15);
        Person p1= new Person(id, name, address, dob);
        session.save(p1);
		session.beginTransaction().commit();
		
		// Item 7
		for(Faculty f : faculty_list){
			if(f.getName().equals("Min Tuyet")){
				f.setSalary(f.getSalary() + (int)(f.getSalary()*.1));
				session.save(f);
				session.beginTransaction().commit();
			}
		}
		
		
		// Item 8
		String s_id = "118784412";
	    Query q = session.createQuery("delete " + Student.class.getName() + " where id = :student_id");
	    q.setParameter("student_id", s_id);
	    int count = q.executeUpdate();
	    System.out.println("Rows affected: " + count);
	    
	    // End the session.
		session.close();
	}
}
