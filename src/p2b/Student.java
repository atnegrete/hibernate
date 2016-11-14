package p2b;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "ID")
public class Student extends Person{
	
	@Column(name = "Classification")
	private String classification;
	
	@Column(name = "GPA")
	private Double gpa;
	
	@Column(name = "MentorID")
	private String mentor;
	
	@Column(name = "CreditHours")
	private int creditHours;
	
	public Student(){}
	
	public Student(String pclassification, Double pgpa, String mentor, int pcredithours){
		this.classification = pclassification;
		this.gpa = pgpa;
		this.mentor = mentor;
		this.creditHours = pcredithours;
	}

	public String getMentor() {
		return mentor;
	}

	public void setMentor(String mentor) {
		this.mentor = mentor;
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
