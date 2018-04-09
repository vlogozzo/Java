import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class CarClient {

	public static void main(String[] args) {
		try {
			System.out.println("client started");
			Car car = new CarImpl();
			

			car.setModel("TL-S");	
			car.setColor("White");
			car.setMileage(240000);
			System.out.println(car.print());

			CarServer CS = (CarServer) Naming.lookup("rmi://localhost/carService");
			CS.registerPlate(car);

			System.out.println(car.print());
		} catch (RemoteException re) {
			System.out.println("RemoteException");
			System.out.println(re);
		} catch (java.lang.ArithmeticException ae) {
			System.out.println("java.lang.ArithmeticException");
			System.out.println(ae);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
