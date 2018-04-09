package shape;

public class Circle implements Shape {
	private double r;

	Circle(String temp) {
		r = Double.parseDouble(temp);
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

	@Override
	public double perimeter() {
		return 2 * Math.PI * r;
	}

	@Override
	public String toString() {
		return String.format("Circle\t\t{r=" + df.format(this.r) + "} perimeter = " + df.format(this.perimeter()));
	}
}
