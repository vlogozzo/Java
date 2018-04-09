package shape;

public class Circle implements Shape {
	private double r;
	private final ShapeArea AREA = () -> Math.PI * getR() * getR();

	Circle(String temp) throws CircleException {
		if (isValid(temp)) {
			r = Double.parseDouble(temp);

		} else {
			throw new CircleException("Invalid radius!");
		}
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	static public boolean isValid(String r) {
		double num = Double.parseDouble(r);
		if (num > 0) {
			return true;
		}
		return false;
	}

	public double area() {
		return AREA.get();
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * r;
	}

	@Override
	public String toString() {
		return String.format("Circle\t\t{r=%5.2f}\t\t\t perimeter = %6.2f\t area = %8.2f", this.getR(),
				this.perimeter(), this.area());
	}
}
