package workshop10;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegisterServer {

	public RegisterServer() {
		try {
			// Create the object implementation
			Register obj = new RegisterImplementation();

			// without the need of running rmiregistry
			Registry registry = LocateRegistry.createRegistry(1997);
			registry.rebind("RegisterPlate", obj);
			System.out.println("RegisterPlate bound in registry");

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static void main(String[] args) {
		new RegisterServer();
		System.out.println("RegisterPlate is running . . .");
	}
}