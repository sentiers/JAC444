// Workshop 6

package shapes;

public class Square extends Rectangle {
	
	private ShapeArea squareArea = () -> getWidth() * getWidth();

	// constructor
	public Square(double s) throws RectangleException {
		super(s, s);
	}

	// calculate area
    	public double getSquareArea(){
        	return squareArea.getArea();
    	}

	// to string
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {s=" + getWidth() + "} perimeter = " + f.format(getPerimeter())
				+ " area = " + f.format(getSquareArea());
	}
}