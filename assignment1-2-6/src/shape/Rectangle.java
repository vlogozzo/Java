package shape;

public class Rectangle extends Parallelogram {
	private final ShapeArea AREA = () -> getW() * getH();

	Rectangle(String temp1, String temp2) throws ParallelogramException, SquareException {
		super(temp1, temp2);
	}

	public double area() {
		return AREA.get();
	}

	@Override
	public String toString() {
		return String.format("Rectangle\t{w=%5.2f, h=%5.2f}\t\t perimeter = %6.2f\t area = %8.2f", this.getW(),
				this.getH(), this.perimeter(), this.area());
	}
}
