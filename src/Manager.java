
import javax.persistence.*;

import com.sun.jndi.cosnaming.IiopUrl.Address;

@Entity  
@Table(name="manager")  
@PrimaryKeyJoinColumn(name="PID")  
public class Manager extends Employee
{
	@Column(name="BUDGET")    
	private int Budget;
	
	
	@OneToOne
	@JoinColumn(name="DID")
	private Department department;
	
	public Manager(){}
	public Manager(int budget)
	{
		Budget=budget;
	}
	public int getBudget()
	{
		return Budget;
	}
	public void setBudget(int budget)
	{
		this.Budget=budget;
	}
	

    public Department getDepartment()  
    {  
        return department;  
    }  
    public void setDepartment(Department department)  
    {  
        this.department = department;  
    }  
}
