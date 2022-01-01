package workshop10;

import java.io.Serializable;

public class Car implements Serializable {
	private String model;
	private String color;
	private int mileage;
	private String plate;

	public Car(String model, String color, int mileage) {
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.plate = "*Undefined";
	}

	// setters
	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	// getters
	public String getModel() {
		return this.model;
	}

	public String getColor() {
		return this.color;
	}

	public int getMileage() {
		return this.mileage;
	}

	public String getPlate() {
		return this.plate;
	}

	@Override
	public String toString() {
		return "[Model]: " + getModel() + "\n[Color]: " + getColor() + "\n[Mileage]: " + getMileage() + "\n[Plate]: "
				+ getPlate();
	}

}