package shape;

public class Triangle implements Shape {
	private double s1;
	private double s2;
	private double s3;

	Triangle(String temp1, String temp2, String temp3) {
		s1 = Double.parseDouble(temp1);
		s2 = Double.parseDouble(temp2);
		s3 = Double.parseDouble(temp3);
	}

	public double getS1() {
		return s1;
	}

	public void setS1(double s1) {
		this.s1 = s1;
	}

	public double getS2() {
		return s2;
	}

	public void setS2(double s2) {
		this.s2 = s2;
	}

	public double getS3() {
		return s3;
	}

	public void setS3(double s3) {
		this.s3 = s3;
	}

	static public boolean isValid(String s1, String s2, String s3) {
		double num1 = Double.parseDouble(s1);
		double num2 = Double.parseDouble(s2);
		double num3 = Double.parseDouble(s3);

		if ((num1 + num2) > num3 && (num1 + num3) > num2 && (num2 + num3) > num1) {
			return true;
		}

		return false;
	}

	@Override
	public double perimeter() {
		return s1 + s2 + s3;
	}

	@Override
	public String toString() {
		return String.format("Triangle\t{s1=" + df.format(this.s1) + ", s2=" + df.format(this.s2) + ", s3="
				+ df.format(this.s3) + "} perimeter = " + df.format(this.perimeter()));
	}

}
