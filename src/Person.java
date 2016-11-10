import java.util.Date;

import javax.persistence.*;


@Entity  
@Table(name = "person")  
/**
 * Implement inheritance by using hibernate JOINED strategy 
 * The nature of InheritanceType.JOINED is that the properties of super entity will be inherited by derived entity. 
 * And in the database the columns which super table contains will not be available in sub table. 
 * The super and derived entity will be associated by @PrimaryKeyJoinColumn. 
 * @author yingw
 *
 */
@Inheritance(strategy = InheritanceType.JOINED) 
public class Person
{
	//@GeneratedValue defines how to generate value for the given column. 
	//GenerationType.AUTO sets @GeneratedValue automatic. 
	//If table has defined any default value or it has defined any auto increment in table then in that case we use
	@Id    
	
	//Need to change column name according to your SQL table
	@Column(name = "PID")  
	private String PersonID;
	@Column(name = "NAME")  
	private String Name;
	@Column(name = "DOB")  
	private Date Dob;
	
	public Person()
	{
		
	}
	public Person(String personID, String name, Date dob)
	{
		this.PersonID=personID;
		this.Name=name;
		this.Dob=dob;
	}
	public String getPersonID()
	{
		return PersonID;
	}
	public void setPersonID(String personID)
	{
		this.PersonID=personID;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String name)
	{
		this.Name=name;
	}
	public Date getDOB()
	{
		return Dob;
	}
	public void setDOB(Date dob)
	{
		this.Dob=dob;
	}
}
