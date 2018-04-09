package shape;

public class Square implements Shape {
	private double s;

	Square(String temp) {
		s = Double.parseDouble(temp);
	}

	public double getS() {
		return s;
	}

	public void setS(double s) {
		this.s = s;
	}

	static public boolean isValid(String s) {
		double num = Double.parseDouble(s);
		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public double perimeter() {
		return s * 4;
	}

	@Override
	public String toString() {
		return String.format("Square\t\t{s=" + df.format(this.s) + "} perimeter = " + this.perimeter());
	}
}
