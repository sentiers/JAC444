// Workshop 2
// Square.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/6/7

package shapes;

public class Square extends Rectangle {

	// constructor
	public Square(double s) throws RectangleException {
		super(s, s);
	}

	// calculate perimeter
	@Override
	public double getPerimeter() {
		return super.getPerimeter();
	}

	// to string
	@Override
	public String toString() {
		return String.format("Square {s=%s}", getWidth());
	}
}