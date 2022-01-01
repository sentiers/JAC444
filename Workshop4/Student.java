package student;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String>();

	// default constructor
	public Student() {

	}
	
	// constructor
	public Student(Integer stdID, String firstName, String lastName, ArrayList<String> courses) {
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.courses = courses;
	}
	
	// setters
	public void setStdId(int stdID) {
		this.stdID = stdID;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCourses(String courses) {
		this.courses.add(courses);
	}

	// getters
	public int getStdId() {
		return stdID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

}