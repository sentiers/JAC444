package workshop8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.text.DecimalFormat;

public class StudentProcess {
	
	// format for double values
	static DecimalFormat f = new DecimalFormat("0.00");

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
		
		
		// Task 6 ------------------------------------------
		System.out.println("\n\nTask 6:\n");
		System.out.println("Student names in order by last name then first name:");
		// full names order by last name and then first name 
		stdList.stream()
			   .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName))
			   .map(Student::getName)
			   .forEach(System.out::println);
		
		
		// Task 7 ------------------------------------------
		System.out.println("\n\nTask 7:\n");
		System.out.println("Students by department:");
		// need to have an object of Map<String, List<Student>>
		// students grouped by department
		Map<String, List<Student>> stdGroup = stdList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment));
		// display
		stdGroup.forEach((key, value) -> {
			System.out.println(key);
			value.forEach(v -> System.out.println("   " + v));
		});
		
		
		// Task 8 ------------------------------------------
		System.out.println("\n\nTask 8:\n");
		System.out.println("Count of Students by department:");
		// need to have an object of Map<String, Long>
		// number of students for each department
		Map<String, Long> numOfStd = stdGroup.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, v -> Long.valueOf(v.getValue().size())));
		// display key and value from map that ordered by key
		new TreeMap<String, Long>(numOfStd).forEach((key, value) -> {
			System.out.println(key + " has " + value + " Student(s)");
		});
		
		
		// Task 9 ------------------------------------------
		System.out.println("\n\nTask 9:\n");
		System.out.println("Sum of Students' grades: " 
		// sum of grades
		+ f.format(stdList.stream()
				          .mapToDouble(Student::getGrade)
				          .summaryStatistics()
				          .getSum()));
		
		
		// Task 10 -----------------------------------------
		System.out.println("\n\nTask 10:\n");
		System.out.println("Average of Students' grades: " 
		// average of grades
		+ f.format(stdList.stream()
				          .mapToDouble(Student::getGrade)
				          .summaryStatistics()
				          .getAverage()));
		
		
	}

}