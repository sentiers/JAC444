package workshop7;

import java.text.DecimalFormat;

public class Student {

	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	DecimalFormat f = new DecimalFormat("0.00");

	public Student(String firstName, String lastName, double grade, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}

	// setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// getters
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public double getGrade() {
		return this.grade;
	}

	public String getDepartment() {
		return this.department;
	}

	// getName (return full name)
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	// toString
	@Override
	public String toString() {
		return String.format("%-8s %-11s %-7s %s", getFirstName(), getLastName(), f.format(getGrade()),
				getDepartment());
	}

	// equals
	public boolean equals(Student student) {
		return this.getFirstName() == student.getFirstName() && this.getLastName() == student.getLastName()
				&& this.getGrade() == student.getGrade() && this.getDepartment() == student.getDepartment();
	}

}