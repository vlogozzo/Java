package shape;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		String line;
		int totalShapes = 0;

		System.out.println("------->JAC 444 Assignment 1<-------");
		System.out.println("------->Task 1 ... <-------");

		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {

			while ((line = br.readLine()) != null) {
				String[] field = line.split(",");
				// shape counting
				if (field[0].equals("Circle") && field.length == 2 && Circle.isValid(field[1])) {
					totalShapes++;
				} else if (field[0].equals("Triangle") && field.length == 4
						&& Triangle.isValid(field[1], field[2], field[3])) {
					totalShapes++;
				} else if (field[0].equals("Square") && field.length == 2 && Square.isValid(field[1])) {
					totalShapes++;
				} else if (field[0].equals("Parallelogram") && field.length == 3
						&& Parallelogram.isValid(field[1], field[2])) {
					totalShapes++;
				} else if (field[0].equals("Rectangle") && field.length == 3 && Rectangle.isValid(field[1], field[2])) {
					totalShapes++;
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {

			Shape[] shapes = new Shape[totalShapes];
			int shapeCount = 0;

			while ((line = br.readLine()) != null) {
				String[] field = line.split(",");
				try {
					if (field[0].equals("Circle") && field.length == 2) {
						shapes[shapeCount] = new Circle(field[1]);
						shapeCount++;
					}

					if (field[0].equals("Triangle") && field.length == 4) {
						shapes[shapeCount] = new Triangle(field[1], field[2], field[3]);
						shapeCount++;
					}

					else if (field[0].equals("Square") && field.length == 2) {
						shapes[shapeCount] = new Square(field[1]);
						shapeCount++;
					}

					else if (field[0].equals("Parallelogram") && field.length == 3) {
						shapes[shapeCount] = new Parallelogram(field[1], field[2]);
						shapeCount++;
					}

					else if (field[0].equals("Rectangle") && field.length == 3) {
						shapes[shapeCount] = new Rectangle(field[1], field[2]);
						shapeCount++;
					}
				} catch (CircleException e) {
					System.out.println(e.getMessage());
				} catch (TriangleException e) {
					System.out.println(e.getMessage());
				} catch (ParallelogramException e) {
					System.out.println(e.getMessage());
				} catch (SquareException e) {
					System.out.println(e.getMessage());
				}

			}
			System.out.println();
			System.out.println(totalShapes + " shapes were created:");
			PrintShapes(shapes);

			System.out.println("------->Task 2 ... <-------");

			double min = 999;
			double max = 0;
			int numMins = 1;
			int numMaxs = 1;
			for (Shape element : shapes) {
				if (element.getClass().equals(Triangle.class) && element.perimeter() == min) {
					numMins++;
				}
				if (element.getClass().equals(Triangle.class) && element.perimeter() < min) {
					min = element.perimeter();
				}
				if (element.getClass().equals(Circle.class) && element.perimeter() == max) {
					numMaxs++;
				}
				if (element.getClass().equals(Circle.class) && element.perimeter() > max) {
					max = element.perimeter();
				}
			}

			Shape[] newShapes = new Shape[shapes.length - numMins - numMaxs];
			int j = 0;
			for (int i = 0; i < shapes.length; i++) {
				if ((shapes[i].getClass().equals(Triangle.class) && shapes[i].perimeter() == min)
						|| (shapes[i].getClass().equals(Circle.class) && shapes[i].perimeter() == max)) {
				} else {
					newShapes[j] = shapes[i];
					j++;
				}
			}
			shapes = newShapes;
			PrintShapes(shapes);

			System.out.println("------->Task 3 ... <-------");
			double triangleTotal = 0;
			double parallelogramTotal = 0;
			for (Shape element : shapes) {
				if (element.getClass().equals(Triangle.class)) {
					triangleTotal += element.perimeter();
				}
				if (element.getClass().equals(Parallelogram.class)) {
					parallelogramTotal += element.perimeter();
				}
			}

			System.out.println("perimeter of Parallelogram is: " + parallelogramTotal);
			System.out.println("perimeter of Triangle is: " + triangleTotal);

			System.out.println("------->Task 4 ... <-------");
			PrintShapes(shapes);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void PrintShapes(Shape[] shapes) {
		for (Shape element : shapes) {
			System.out.println(element.toString());
		}
	}

}