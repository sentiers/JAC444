// Workshop 2
// Parallelogram.java
//
// Name: Hyunji Cho
// Seneca Student ID: 128065182
// Seneca email: hcho51@myseneca.ca
// Date of completion: 2020/6/7

package shapes;

public class Parallelogram extends Rectangle {
	
	// constructor
    public Parallelogram(double w, double l) throws RectangleException {
        super(w,l);
    }

    // calculate perimeter
    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    // to string
	@Override
	public String toString() {
		return String.format("Parallelogram {w=%s, h=%s}", getWidth(), getLength());
	}
}

