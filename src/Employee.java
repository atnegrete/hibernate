import javax.persistence.*;
@Entity  
@Table(name="employee")  
/** We are using @PrimaryKeyJoinColumn annotation 
 * which will create a primary key named PID for employee table which will reference to person table primary key(PID).
 *
 */
@PrimaryKeyJoinColumn(name="PID")  
public class Employee extends Person
{
@Column(name="SALARY")    
private int Salary;
//@Column(name="PID" ) 
//private String EmployeeID;
//@Column(name="DID") 
//private String DepartmentID;

@ManyToOne
@JoinColumn(name="DID")
private Department department;


public Employee(){}
public Employee(String eid,int salary, String did)
{
	//this.EmployeeID=eid;
	this.Salary=salary;
	//this.DepartmentID=did;
}

public int getSalary()
{
	return Salary;
}
public void setSalary(int salary)
{
	this.Salary=salary;
}
public Department getDepartment()
{
	return department;
}
public void setDepartment(Department department)
{
	this.department=department;
}

}

