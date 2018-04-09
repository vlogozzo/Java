import java.rmi.Naming;

public class CarServer {

	public CarServer() {
		try {
			Car c = new CarImpl();
			Naming.rebind("rmi://localhost/carService", c);
			System.out.println("server start");
			//c.setPlate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String args[]) {
		new CarServer();
		
	}
}
