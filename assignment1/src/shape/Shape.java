package shape;

import java.text.*;

@FunctionalInterface
public interface Shape {
	DecimalFormat df = new DecimalFormat("#.0");

	double perimeter();
	// double area();
}
