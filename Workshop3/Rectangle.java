// Workshop 3
// Rectangle.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/6/8

package shapes;

public class Rectangle implements Shape {
	private double width;
	private double length;

	// constructor
	public Rectangle(double w, double l) throws RectangleException {
		if (isValid(w, l)) {
			width = w;
			length = l;
		} else {
			throw new RectangleException("Invalid side!");
		}
	}

	// validation
	public boolean isValid(double w, double l) {
		return w > 0 && l > 0;
	}

	// setters
	public void setWidth(double w) {
		width = w;
	}

	public void setLength(double l) {
		length = l;
	}

	// getters
	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	// calculate perimeter
	@Override
	public double getPerimeter() {
		return 2 * (getWidth() + getLength());
	}

	// to string
	@Override
	public String toString() {
		return String.format("Rectangle {w=%s, h=%s}", getWidth(), getLength());
	}

}
