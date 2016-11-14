package p2b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
@PrimaryKeyJoinColumn(name = "ID")
public class Faculty extends Person{

	@Column(name = "Rank")
	private String rank;
	
	@Column(name = "Salary")
	private int salary;
	
	public Faculty(){}
	
	public Faculty(String prank, int psalary){
		this.rank = prank;
		this.salary = psalary;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
