public interface Car extends java.rmi.Remote {

	public void setModel(String model) throws java.rmi.RemoteException;
	public void setColor(String color) throws java.rmi.RemoteException;
	public void setMileage(double mileage) throws java.rmi.RemoteException;
	public void setPlate(int plate) throws java.rmi.RemoteException;

	public String print() throws java.rmi.RemoteException;
}
