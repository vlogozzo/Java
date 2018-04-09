package shape;

public class Parallelogram implements Shape {
	private double w;
	private double h;

	Parallelogram(String temp1, String temp2) {
		this.w = (Double.parseDouble(temp1));
		this.h = (Double.parseDouble(temp2));
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	static public boolean isValid(String w, String h) {
		double num1 = Double.parseDouble(w);
		double num2 = Double.parseDouble(h);
		if (num1 > 0 && num2 > 0) {
			return true;
		}
		return false;
	}

	@Override
	public double perimeter() {
		return (w * 2) + (h * 2);
	}

	@Override
	public String toString() {
		return String.format("Parallelogram\t{w=" + df.format(this.w) + ", h=" + df.format(this.h) + "} perimeter = "
				+ df.format(this.perimeter()));
	}
}
