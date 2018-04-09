package shape;

import java.text.*;

@FunctionalInterface
public interface Shape {
	DecimalFormat df = new DecimalFormat(".0000#");

	double perimeter();
	// double area();
}
