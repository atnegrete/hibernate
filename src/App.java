

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class App
{
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
         //first HQL: Get all employees' name
		 String hql = "from Employee";
		 
             Query query = session.createQuery(hql);
             List<Employee> list = query.list();
             for (Employee e : list) {
                 System.out.println(e.getName());        
             }
             //Another way to get empoyee's name;
          Query hq11=session.createQuery("select e.Name from Employee e");
          System.out.println(hq11.list());
          
          //Get manager's Name(two inheritance: Manager inheritance from Employee, Employee inheritance from Person)
          Query hq12=session.createQuery("select m.Name from Manager m");
          System.out.println(hq12.list());
          
      //second HQL: get all employee's ID who work in department 1, 
      // This method is not efficient,please look at the third HQL;
      Query hq2 = session.createQuery("from Department where DepartmentID = 'Dept001' ");
      List<Department> list1 =hq2.list();
      for(Department d:list1)
      {
    	  Set<Employee> list2= d.getAllEmployees();
    	  for(Employee e1:list2)
    	  {
    		  System.out.println(e1.getPersonID());
    	  }
      }
      //third HQL: get all employee's name who work in department 1,
      //we use allEmployees to get all of employee who work in department 1 
      Query hq3 = session.createQuery("select d.allEmployees from Department d where d.DepartmentID = 'Dept001' ");
      List<Employee> list3=hq3.list(); 
      for (Employee n : list3) {
          System.out.println(n.getName());
      }
      
      //forth HQL: get the total salary of employee 
      Query hq4=session.createQuery("select sum(Salary) from Employee");  
      List<Integer> list4=hq4.list();
      System.out.println(list4);
    		  
     //fifth HQL: find the manager's budget for department 2
      
      Query hq5=session.createQuery("select d.manager.Budget from Department d where d.DName = 'information service'");
      System.out.println(hq5.list());
      
      
      //Sixth HQL: another way to find the manager's budget for department 2
      Query hq6=session.createQuery("select d.manager from Department d where d.DName = 'information service'");
      List<Manager> list6=hq6.list();
      for (Manager m : list6) {
          System.out.println(m.getBudget());
      }
  	
  	//Seventh HQL: Get department's name which manageby by 'Mark Allen';
  	  
  	Query hq7=session.createQuery("select m.department.DName from Manager m where m.Name = 'Mark Allen'");
        System.out.println(hq7.list());
    
       
        //Eighth Ninth Tenth HQL:Three ways to get employees' salary and name whose salary >70000;
        //First method
       Query hq8=session.createQuery("select e.Salary, e.Name from Employee e where e.Salary >70000");
       List <Object[]>list8=hq8.list();
       for(Object[] employee: list8){
           Integer Salary = (Integer)employee[0];
           String Name = (String)employee[1];
         System.out.print(Salary+" "+Name);
         System.out.println();
       }
       //Second Method
       Query hq9=session.createQuery("select e from Employee e where e.Salary >70000");
       List<Employee> list9=hq9.list();
       for(Employee e:list9)
       {
    	   System.out.print(e.getSalary()+" ");
    	   System.out.println(e.getName());
       }
       //Third method
       Query hq10=session.createQuery("from Employee");
       List<Employee> list10=hq10.list();
       for(Employee e:list10)
       {
    	   if(e.getSalary()>70000)
    	   {
        	   System.out.print(e.getSalary()+" ");
        	   System.out.println(e.getName());
    	   }
       }
       
       
       //Insert an person whose id is 006, name is Lily Ann, DOB is 1978-01-05;   
       Date date=new Date(1978-01-05);
       Person p1=new Person();
       p1.setPersonID("006");
       p1.setName("Lily Ann");
       p1.setDOB(date);
       session.save(p1);
       
       session.beginTransaction().commit();
       
       
           
       //Update:Increase all of employees' salary by 10%
       //Employee is an object not a tuple and Salary is private parameter under the object Eployee
       Query hq22=session.createQuery("UPDATE Employee set Salary=Salary*1.1");
       hq22.executeUpdate();
       
       //Delete an employee
       Query hq33=session.createQuery("DELETE FROM Employee where id = :employee_id");
       hq33.setParameter("employee_id", "002");
       int count = hq33.executeUpdate();
       System.out.println("Rows affected: " + count);
       //In reality, manager table also be updated, too, but not reported into count.
       //Close the session
	  session.close(); 
	}

}




