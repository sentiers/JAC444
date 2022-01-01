package student;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadStudent {

	public static void main(String[] args) {

		try {
			FileInputStream fin = new FileInputStream("Student.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);

			System.out.println("--------Getting Student Information Program--------");
			System.out.println("------------------------------------Hyunji Cho-----");

			// print all the objects
			while (fin.available() != 0) {
				Student student = (Student) oin.readObject();
				System.out.println("\n====Student Information====");
				System.out.println("StudentID: " + student.getStdId());
				System.out.println("First name: " + student.getFirstName());
				System.out.println("Last name: " + student.getLastName());
				System.out.println("Courses: " + student.getCourses());
			}

			System.out.println("\n\n. . . . End of Data");
			oin.close();
			fin.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}