// Workshop 6

package shapes;

import java.text.DecimalFormat;

public class Rectangle implements Shape {

	private double width;
	private double length;
	private ShapeArea rectangleArea = () -> getWidth() * getLength();
	DecimalFormat f = new DecimalFormat("0.00000");

	// constructor
	public Rectangle(double w, double l) throws RectangleException {
		if (w > 0 && l > 0) {
			this.width = w;
			this.length = l;
		} else {
			throw new RectangleException("Invalid side!");
		}
	}

	// setters
	public void setWidth(double w) throws RectangleException {
		if (w > 0) {
			this.width = w;
		} else {
			throw new RectangleException("Invalid width!");
		}
	}

	public void setLength(double l) throws RectangleException {
		if (l > 0) {
			this.length = l;
		} else {
			throw new RectangleException("Invalid length!");
		}
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

	// calculate area
	public double getRectangleArea() {
		return rectangleArea.getArea();
	}

	// to string
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getLength() + "} perimeter = "
				+ f.format(getPerimeter()) + " area = " + f.format(getRectangleArea());
	}

}
