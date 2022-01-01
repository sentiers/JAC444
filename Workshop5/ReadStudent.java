package application;

import java.io.*;

public class ReadStudent {
	public static String display() {
		String result = "";
		try {
			FileInputStream fin = new FileInputStream("Student.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			while (fin.available() != 0) {
				Student student = (Student) oin.readObject();
				if (student != null) {
					// to display all students' information
					result += student.toString();
				}
			}
			oin.close();
			fin.close();

		} catch (IOException | ClassNotFoundException e) {
			// when there is an error, set string notification
			result = "Error! File is not exist";
		}
		return result;
	}
}