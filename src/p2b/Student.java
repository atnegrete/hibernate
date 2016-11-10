package p2b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
@PrimaryKeyJoinColumn(name = "ID")
public class Student {
	
	@Column(name = "Classification")
	private String classification;
	@Column(name = "GPA")
	private Double gpa;
	@ManyToOne
	@JoinColumn(name = "ID")
	private Faculty mentor;
	@Column(name = "CreditHours")
	private int creditHours;
	
	public Student(){}
	
	public Student(String pclassification, Double pgpa, int pcredithours){
		this.classification = pclassification;
		this.gpa = pgpa;
		this.creditHours = pcredithours;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	

}
