// Workshop 2
// Main.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/6/7

package shapes;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args){	
		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... Hyunji Cho <-------");

		String s;
		int numData = 0;
		int numShape = 0;

		// calculate the number of data
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			while ((s = br.readLine()) != null) {
				numData++;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		// create data structure for shapes
		Shape[] shapes = new Shape[numData];

		// checks line by line if it's valid, and calculate the number of shapes
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			while ((s = br.readLine()) != null) {
				try {
					String[] tokens = s.split(",");

					if (tokens[0].equals("Circle") && tokens.length == 2) {
						shapes[numShape] = new Circle(Double.parseDouble(tokens[1]));
						numShape++;
					} else if (tokens[0].equals("Triangle") && tokens.length == 4) {
						shapes[numShape] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
						numShape++;
					} else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
						shapes[numShape] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						numShape++;
					} else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
						shapes[numShape] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
						numShape++;
					} else if (tokens[0].equals("Square") && tokens.length == 2) {
						shapes[numShape] = new Square(Double.parseDouble(tokens[1]));
						numShape++;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// Task 1 result
		System.out.println("\n" + numShape + " shapes were created:");
		printResult(shapes);
		// ------------------------------------ Task 1 end
	
	}

	public static void printResult(Shape[] shapes) {
		for (Shape s : shapes) {
			if (s != null) {
				System.out.printf("%s perimeter = %g \n\n", s, s.getPerimeter());
			}
		}
	}

}