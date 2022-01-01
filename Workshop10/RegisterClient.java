package workshop10;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RegisterClient {
	Register obj = null;

	public Car action(Car car) {
		try {
			obj = (Register) Naming.lookup("rmi://localhost:1997/RegisterPlate");
			car.setPlate(obj.registerCar(car));
		} catch (NotBoundException | MalformedURLException | RemoteException e) {
			System.out.println(e.getMessage());
		}
		return car;
	}

	public static void main(String[] args) {

		Car car = new Car("Hyundai Genesis GV80", "Black", 43276);

		System.out.println("====== Car Information ======");
		System.out.println(car.toString());
		System.out.println("=============================");

		System.out.println("\nRegistering new plate . . .");
		RegisterClient rc = new RegisterClient();
		rc.action(car);
		System.out.println("Done!\n");

		System.out.println("====== Car Information ======");
		System.out.println(car.toString());
		System.out.println("=============================");

	}
}
