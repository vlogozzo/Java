import java.rmi.RemoteException;
@SuppressWarnings("serial")
public class CarImpl extends java.rmi.server.UnicastRemoteObject implements Car {
	private String model;
	private String color;
	private double mileage;
	private int plate;

	protected CarImpl() throws RemoteException {
		super();
	}

	@Override
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public void setPlate() {
		this.plate = this.hashCode();
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Car [model=" + model + ", color=" + color + ", mileage=" + mileage + ", plate=" + plate + "]";
	}

}
