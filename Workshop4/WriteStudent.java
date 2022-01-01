package student;

import java.io.FileOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WriteStudent {

	public static void main(String[] args) {

		try {
			FileOutputStream fout = new FileOutputStream(new File("Student.txt"));
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			int option = 0;
			int stdID = 0;
			String firstName = null;
			String lastName = null;
			String courses = null;
			boolean error = false;

			System.out.println("--------Creating Student Information Program--------");
			System.out.println("-------------------------------------Hyunji Cho-----");

			do {
				System.out.println("\n========OPTIONS========");
				System.out.println("1. Create New Student");
				System.out.println("0. Exit");
				option = Integer.parseInt(in.readLine());

				switch (option) {
				case 1:
					// new student
					Student student = new Student();

					// student id ex) 128065182
					do {
						System.out.println("StudentID: ");
						stdID = Integer.parseInt(in.readLine());
						if (stdID < 100000000 || stdID > 999999999) {
							error = true;
							System.out.println("*** StudentID should be 9 digits!");
						} else {
							student.setStdId(stdID);
							error = false;
						}
					} while (error);

					// first name
					do {
						System.out.println("First name: ");
						firstName = in.readLine();
						if (firstName.length() == 0) {
							error = true;
							System.out.println("*** First name is missing!");
						} else {
							student.setFirstName(firstName);
							error = false;
						}
					} while (error);

					// last name
					do {
						System.out.println("Last name: ");
						lastName = in.readLine();
						if (lastName.length() == 0) {
							error = true;
							System.out.println("*** Last name is missing!");
						} else {
							student.setLastName(lastName);
							error = false;
						}
					} while (error);

					// courses ex) JAC444, WEB422, BCI433, EAC594
					do {
						System.out.println("Courses: ");
						courses = in.readLine();
						if (courses.length() == 0) {
							error = true;
							System.out.println("*** Course is missing!");
						} else {
							String[] temp = courses.split(",");
							for (int i = 0; i < temp.length; i++) {
								student.setCourses(temp[i]);
							}
							error = false;
						}

					} while (error);

					// write object
					oout.writeObject(student);
					System.out.println(". . . . Student Created!");
					break;

				case 0:
					// exit program
					System.out.println(". . . . Exit Program");
					break;
				}
			} while (option != 0);

			in.close();
			fout.close();
			oout.close();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}