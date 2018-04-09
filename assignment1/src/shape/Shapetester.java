package shape;

import java.io.*;

public class Shapetester {

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
				}

				else if (field[0].equals("Triangle") && field.length == 4
						&& Triangle.isValid(field[1], field[2], field[3])) {
					totalShapes++;
				}

				else if (field[0].equals("Square") && field.length == 2 && Square.isValid(field[1])) {
					totalShapes++;
				}

				else if (field[0].equals("Parallelogram") && field.length == 3
						&& Parallelogram.isValid(field[1], field[2])) {
					totalShapes++;
				}

				else if (field[0].equals("Rectangle") && field.length == 3 && Rectangle.isValid(field[1], field[2])) {
					totalShapes++;
				} else { // error messages
					if (field[0].equals("Circle")) {
						System.out.println("Invalid radius!");
					}

					else if (field[0].equals("Triangle") || field[0].equals("Parallelogram")
							|| field[0].equals("Rectangle")) {
						System.out.println("Invalid side(s)!");
					}

					else if (field[0].equals("Square")) {
						System.out.println("Invalid side!");
					}
				}
			}
			br.close();
			System.out.println();
			System.out.println(totalShapes + " shapes were created:");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {

			Shape[] shapes = new Shape[totalShapes];
			int shapeCount = 0;

			while ((line = br.readLine()) != null) {
				String[] field = line.split(",");

				if (field[0].equals("Circle") && field.length == 2 && Circle.isValid(field[1])) {
					shapes[shapeCount] = new Circle(field[1]);
					shapeCount++;
				}

				else if (field[0].equals("Triangle") && field.length == 4
						&& Triangle.isValid(field[1], field[2], field[3])) {
					shapes[shapeCount] = new Triangle(field[1], field[2], field[3]);
					shapeCount++;
				}

				else if (field[0].equals("Square") && field.length == 2 && Square.isValid(field[1])) {
					shapes[shapeCount] = new Square(field[1]);
					shapeCount++;
				}

				else if (field[0].equals("Parallelogram") && field.length == 3
						&& Parallelogram.isValid(field[1], field[2])) {
					shapes[shapeCount] = new Parallelogram(field[1], field[2]);
					shapeCount++;
					;
				}

				else if (field[0].equals("Rectangle") && field.length == 3 && Rectangle.isValid(field[1], field[2])) {
					shapes[shapeCount] = new Rectangle(field[1], field[2]);
					shapeCount++;
				}
			}

			for(Shape element : shapes) {
				System.out.println(element.toString());
			}
		} catch (

		IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
