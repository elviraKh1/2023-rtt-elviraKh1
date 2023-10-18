package inheritance;

public class Circle extends Shape {
	private double diameter;

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getRadius() {
		return diameter / 2;
	}

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(getRadius(), 2);
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * getRadius();
	}
}
