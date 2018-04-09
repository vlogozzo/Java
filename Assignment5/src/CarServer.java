import java.rmi.Naming;
import java.rmi.RemoteException;

public class CarServer {
	
	public static void registerPlate(Car c) throws RemoteException {
		c.setPlate(c.hashCode());
	}
	
	public static void main(String args[]) {		
		try {
			Car c = new CarImpl();
			Naming.rebind("rmi://localhost/carService", c);
			registerPlate(c);
			System.out.println("server start");
			//c.setPlate();
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
}
