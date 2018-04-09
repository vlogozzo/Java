import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class CarClient {

	public static void main(String[] args) {
		try {
			System.out.println("client started");
			Car car = (Car) Naming.lookup("rmi://localhost/carService");

			car.setModel("TL-S");
			car.setColor("White");
			car.setMileage(240000);
			System.out.println(car.print());

			car.setPlate();

			System.out.println(car.print());

		} catch (MalformedURLException murle) {
			System.out.println("MalformedURLException");
			System.out.println(murle);
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (NotBoundException nbe) {
			System.out.println("NotBoundException");
			System.out.println(nbe);
		} catch (java.lang.ArithmeticException ae) {
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		}
	}
}
