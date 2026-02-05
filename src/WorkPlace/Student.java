package WorkPlace;

import java.io.Serializable;

public class Student implements Serializable {
	public String name;
	public long rollNumber;
	private String email; // Private 
	public Attendance attendance;
	String gender;
	
	// Defualt Constructor
	public Student() {}
	
	public Student(String name,long rollNumber,String gender) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.gender = gender;
		attendance = new Attendance();
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}