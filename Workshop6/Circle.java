// Workshop 6

package shapes;

import java.text.DecimalFormat;

public class Circle implements Shape {

	private double radius;
	private ShapeArea circleArea = () -> Math.PI * getRadius() * getRadius();
	DecimalFormat f = new DecimalFormat("0.00000");

	// constructor
	public Circle(double r) throws CircleException {
		if (r > 0) {
			this.radius = r;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}

	// setter
	public void setRadius(double r) throws CircleException {
		if (r > 0) {
			this.radius = r;
		} else {
			throw new CircleException("Invalid radius!");
		}
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

	// calculate area
	public double getCircleArea() {
		return circleArea.getArea();
	}

	// to string
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {r=" + getRadius() + "} perimeter = " + f.format(getPerimeter())
				+ " area= " + f.format(getCircleArea());
	}

}
