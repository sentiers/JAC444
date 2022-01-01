package workshop10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RegisterImplementation extends UnicastRemoteObject implements Register {

	public RegisterImplementation() throws RemoteException {
		super();
	}

	@Override
	public String registerCar(Car car) throws RemoteException {
		return String.valueOf(car.hashCode());
	}
}