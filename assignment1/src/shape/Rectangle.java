package shape;

public class Rectangle extends Parallelogram {

	Rectangle(String temp1, String temp2) {
		super(temp1, temp2);
	}

	@Override
	public String toString() {
		return String.format("Rectangle\t{w=" + df.format(this.getW()) + ", h=" + df.format(this.getH())
				+ "} perimeter = " + df.format(this.perimeter()));
	}
}
