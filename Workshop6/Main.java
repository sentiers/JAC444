// Workshop 6

package shapes;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("-------> JAC 444 Workshop 6 <-------");
		System.out.println("-------> Task 1 + 4 Hyunji Cho <-------");

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
					int len = tokens.length;

					switch (tokens[0]) {
					case "Circle":
						if (len == 2) {
							shapes[numShape] = new Circle(Double.parseDouble(tokens[1]));
							numShape++;
						}
						break;
					case "Triangle":
						if (len == 4) {
							shapes[numShape] = new Triangle(Double.parseDouble(tokens[1]),
									Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
							numShape++;
						}
						break;
					case "Parallelogram":
						if (len == 3) {
							shapes[numShape] = new Parallelogram(Double.parseDouble(tokens[1]),
									Double.parseDouble(tokens[2]));
							numShape++;
						}
						break;
					case "Rectangle":
						if (len == 3) {
							shapes[numShape] = new Rectangle(Double.parseDouble(tokens[1]),
									Double.parseDouble(tokens[2]));
							numShape++;
						}
						break;
					case "Square":
						if (len == 2) {
							shapes[numShape] = new Square(Double.parseDouble(tokens[1]));
							numShape++;
						}
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		// Task 1 + 4 result
		System.out.println("\n" + numShape + " shapes were created:");
		printResult(shapes);

	}

	public static void printResult(Shape[] shapes) {
		for (Shape s : shapes) {
			if (s != null) {
				System.out.println(s);
				System.out.printf("\n");
			}
		}
	}

}