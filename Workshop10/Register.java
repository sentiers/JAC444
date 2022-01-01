package workshop10;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Register extends Remote {
	public String registerCar(Car car) throws RemoteException;
}