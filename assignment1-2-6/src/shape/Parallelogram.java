package shape;

public class Parallelogram implements Shape {
	private double w;
	private double h;

	Parallelogram(String temp1, String temp2) throws ParallelogramException, SquareException {
		if (isValid(temp1, temp2)) {
			this.w = (Double.parseDouble(temp1));
			this.h = (Double.parseDouble(temp2));
		} else {
			if (this instanceof Square) {
				throw new SquareException("Invalid side!");
			} else {
				throw new ParallelogramException("Invalid side(s)!");
			}
		}
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
		return String.format("Parallelogram\t{w=%5.2f, h=%5.2f}\t\t perimeter = %6.2f", this.getH(), this.getW(),
				this.perimeter());
	}
}
