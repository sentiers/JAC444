// Workshop 6

package shapes;

public class Parallelogram extends Rectangle {

	// constructor
	public Parallelogram(double w, double l) throws RectangleException {
		super(w, l);
	}

	// to string
	@Override
	public String toString() {
		return getClass().getSimpleName() + " {w=" + getWidth() + ", h=" + getLength() + "} perimeter = "
				+ f.format(getPerimeter());
	}

}
