package shape;

public class Square extends Rectangle {

	Square(String temp) throws ParallelogramException, SquareException {
		super(temp, temp);
	}

	static public boolean isValid(String s) {
		double num = Double.parseDouble(s);

		if (num > 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Square\t\t{s=%6.2f}\t\t\t perimeter = %6.2f\t area = %8.2f", this.getH(),
				this.perimeter(), this.area());
	}
}
