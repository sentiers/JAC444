// Workshop 2
// Circle.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/6/7

package shapes;

public class Circle implements Shape {
	private double radius;

	// constructor
	public Circle(double r) throws CircleException {
		if (isValid(r)) {
			radius = r;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}

	// validation
	public boolean isValid(double r) {
		return r > 0;
	}

	// setter
	public void setRadius(double r) {
		radius = r;
	}
	
	// getter
	public double getRadius() {
		return radius;
	}

	// calculate perimeter
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}

	// to string
	@Override
	public String toString() {
		return String.format("Circle {r=%s}", getRadius());
	}

}
