// Workshop 6

package shapes;

import java.text.DecimalFormat;

public class Triangle implements Shape {

	private double side1;
	private double side2;
	private double side3;
	DecimalFormat f = new DecimalFormat("0.00000");

	// constructor
	public Triangle(double s1, double s2, double s3) throws TriangleException {
		if (((s1 + s2) > s3 && (s1 + s3) > s2 && (s2 + s3) > s1) && (s1 > 0 && s2 > 0 && s3 > 0)) {
			this.side1 = s1;
			this.side2 = s2;
			this.side3 = s3;
		} else {
			throw new TriangleException("Invalid side(s)!");
		}
	}

	// setters
	public void setSide1(double s1) throws TriangleException {
		if (s1 > 0) {
			this.side1 = s1;
		} else {
			throw new TriangleException("Invalid side!");
		}
	}

	public void setSide2(double s2) throws TriangleException {
		if (s2 > 0) {
			this.side2 = s2;
		} else {
			throw new TriangleException("Invalid side!");
		}
	}

	public void setSide3(double s3) throws TriangleException {
		if (s3 > 0) {
			this.side3 = s3;
		} else {
			throw new TriangleException("Invalid side!");
		}
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
		return getClass().getSimpleName() + " {s1=" + getSide1() + ", s2=" + getSide2() + ", s3=" + getSide3()
				+ "} perimeter = " + f.format(getPerimeter());
	}
}