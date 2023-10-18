package inheritance;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle();
		rect.setName("Rectangle");
		rect.setHeight(5);
		rect.setWidth(10);

		Circle circle = new Circle();
		circle.setName("Circle");
		circle.setDiameter(100);

		Triangle triangle = new Triangle();
		triangle.setName("Triangle");
		triangle.setSide1(3);
		triangle.setSide2(3);
		triangle.setSide3(3);
		
		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(rect);
		shapes.add(circle);
		shapes.add(triangle);
		for (Shape shape : shapes) {
			System.out.println("The area of a " + shape.getName() + " is " + shape.calculateArea());
		}
	}
}
