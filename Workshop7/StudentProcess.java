package workshop7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentProcess {

	// Create an array of Students
	private static Student[] students = { 
			new Student("Jack", "Smith", 50.0, "IT"),
			new Student("Aaron", "Johnson", 76.0, "IT"), 
			new Student("Maaria", "White", 35.8, "Business"),
			new Student("John", "White", 47.0, "Media"), 
			new Student("Laney", "White", 62.0, "IT"),
			new Student("Jack", "Jones", 32.9, "Business"), 
			new Student("Wesley", "Jones", 42.89, "Media") };

	
	public static void main(String[] args) {

		// make student list
		List<Student> stdList = Arrays.asList(students);
		
		
		// Task 1 ------------------------------------------
		System.out.println("\n\nTask 1:\n");
		System.out.println("Complete Student list:");
        // list every students
		stdList.forEach(System.out::println);

		
		// Task 2 ------------------------------------------
		System.out.println("\n\nTask 2:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
        // sorted students by grades (>=50 and <=100)
		stdList.stream()
		       .filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
			   .sorted(Comparator.comparing(Student::getGrade))
			   .forEach(System.out::println);

		
		// Task 3 ------------------------------------------
		System.out.println("\n\nTask 3:\n");
		System.out.println("First Student who got 50.0-100.0:");
        // get first student who got >=50 and <=100 and print value that is present		
		stdList.stream()
		       .filter(s -> s.getGrade() >= 50 && s.getGrade() <= 100)
		       .findFirst()
		       .ifPresent(System.out::println);

		
		// Task 4 ------------------------------------------
		System.out.println("\n\nTask 4:\n");
		System.out.println("Students in ascending order by last name then first:");
		// ascending by last name, and then first name
		stdList.stream()
		       .sorted(Comparator.comparing(Student::getFirstName))
			   .sorted(Comparator.comparing(Student::getLastName))
			   .forEach(System.out::println);
		
		System.out.println("\nStudents in descending order by last name then first:");
		// descending by last name, and then first name
		stdList.stream()
		       .sorted(Comparator.comparing(Student::getFirstName).reversed())
			   .sorted(Comparator.comparing(Student::getLastName).reversed())
			   .forEach(System.out::println);

		
		// Task 5 ------------------------------------------
		System.out.println("\n\nTask 5:\n");
		System.out.println("Unique Student last names:");
        // display unique last names
		stdList.stream()
		       .sorted(Comparator.comparing(Student::getLastName))
		       .map(Student::getLastName)
		       .distinct()
			   .forEach(System.out::println);

	}

}