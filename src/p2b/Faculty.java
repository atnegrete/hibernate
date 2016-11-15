package p2b;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
@PrimaryKeyJoinColumn(name = "FacultyID")
public class Faculty extends Person{

	@Column(name = "Rank")
	private String rank;
	
	@Column(name = "Salary")
	private int salary;
	
	@OneToMany(mappedBy="mentor", cascade = CascadeType.ALL)
	private Set<Student> mentored_students;

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
	
	public Set<Student> getMentored_students() {
		return mentored_students;
	}

	public void setMentored_students(Set<Student> mentored_students) {
		this.mentored_students = mentored_students;
	}
	
}
