import java.rmi.Naming;
import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class CarServer implements java.rmi.Remote, java.io.Serializable {

	public void registerPlate(Car c) {
		try {
			c.setPlate(c.hashCode());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			CarServer CS = new CarServer();
			Naming.rebind("rmi://localhost/carService", CS);
			
			System.out.println("server start");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
