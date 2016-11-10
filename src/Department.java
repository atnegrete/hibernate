

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="department")
public class Department
{
	@Id
	@GeneratedValue  //AUTO is the default strategy, so this definition is equivalent to @Inheritance(strategy = InheritanceType.JOINED)
	@Column(name="DID")
    private String DepartmentID;
	@Column(name="DNAME")
    private String DName;
	
	@OneToMany(mappedBy="department")
    private Set<Employee> allEmployees;
	
	@OneToOne(mappedBy="department")
	private Manager manager;

public Department(){}
public Department(String departmentID, String dName)
{
	this.DepartmentID=departmentID;
	this.DName=dName;
}

public String getDepartmentID()
{
	return DepartmentID;
}
public void setDepartmentID(String deparmentID)
{
	this.DepartmentID=deparmentID;
}
public String getDName()
{
	return DName;
}
public void setDName(String dName)
{
	this.DName=dName;
}
public Set<Employee> getAllEmployees() {
    return allEmployees;
 }
 public void setAllEmployees( Set<Employee> allEmps ) {
    this.allEmployees = allEmps;
 }
 
 @OneToOne(cascade=CascadeType.ALL)  //It shows how to set cascade action for one to mapping.
 @JoinColumn(name="MANAGEBY") 
 public Manager getManager()
 {
	 return manager;
 }
 public void setManager(Manager manager)
 {
	 this.manager=manager;
 }

}

