// Workshop 3
// Triangle.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/6/8

package shapes;

public class Triangle implements Shape {
	private double side1;
	private double side2;
	private double side3;

	// constructor
	public Triangle(double s1, double s2, double s3) throws TriangleException {
		if (isValid(s1, s2, s3)) {
			side1 = s1;
			side2 = s2;
			side3 = s3;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}

	// validation - Triangle Inequality Theorem
	public boolean isValid(double s1, double s2, double s3) {
		return ((s1 + s2) > s3 && (s1 + s3) > s2 && (s2 + s3) > s1) && (s1 > 0 && s2 > 0 && s3 > 0);
	}

	// setters
	public void setSide1(double s1) {
		side1 = s1;
	}

	public void setSide2(double s2) {
		side2 = s2;
	}

	public void setSide3(double s3) {
		side3 = s3;
	}

	// getters
	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}

	// calculate perimeter
	@Override
	public double getPerimeter() {
		return getSide1() + getSide2() + getSide3();
	}

	// to string
	@Override
	public String toString() {
		return String.format("Triangle {s1=%s, s2=%s, s3=%s}", getSide1(), getSide2(), getSide3());
	}
}