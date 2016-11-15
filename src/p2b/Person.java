package p2b;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED) 
public class Person {

	@Id
	
	@Column(name = "ID")
	private String PersonID;
	@Column(name = "Name")
	private String Name;
	@Column(name = "Address")
	private String Address;
	@Column(name = "DOB")
	private Date Dob;
	
	/*
	 * Blank constructor.
	 */
	public Person(){}
	
	public Person(String pid, String pname, String paddress, Date pdob){
		this.PersonID = pid;
		this.Name = pname;
		this.Address = paddress;
		this.Dob = pdob;
	}
	
	public String getPersonID() {
		return PersonID;
	}

	public void setPersonID(String personID) {
		PersonID = personID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getDob() {
		return Dob;
	}

	public void setDob(Date dob) {
		Dob = dob;
	}	
	
}
