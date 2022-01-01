package application;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class WriteStudent {
	public static String add(String stdID, String stdFirstName, String stdLastName, String stdCourses) {

		// Student Array List
		ArrayList<Student> studentList = new ArrayList<Student>();
		String result = "";

		// serialize the student information objects that already exist in file
		try {
			FileInputStream fin = new FileInputStream("Student.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			while (fin.available() != 0) {
				Student student = (Student) oin.readObject();
				if (student != null) {
					studentList.add(student);
				}
			}
			oin.close();
			fin.close();

		} catch (IOException | ClassNotFoundException e) {
			// when there is an error, set string notification
			result = "Error! File is not exist";
		}

		// add ONE new student information just entered by user
		try {
			FileOutputStream fout = new FileOutputStream("Student.txt");
			ObjectOutputStream oout = new ObjectOutputStream(fout);

			// studentID
			int studentID = Integer.parseInt(stdID);

			// courses
			String[] courses = stdCourses.split("\n");
			ArrayList<String> coursesList = new ArrayList<String>(Arrays.asList(courses));

			// new student object and add to the list
			Student student = new Student(studentID, stdFirstName, stdLastName, coursesList);
			studentList.add(student);

			// write all the student objects from the list to the file
			for (Student s : studentList) {
				oout.writeObject(s);
			}
			
			fout.close();
			oout.close();
			result = "Saved successfully into 'Student.txt'";

		} catch (IOException e) {
			// when there is an error, set string notification
			result = "Error!";
		}
		return result;
	}
}