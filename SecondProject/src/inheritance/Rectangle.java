package inheritance;

public class Rectangle extends Shape {

	Rectangle() {
		super();
	}

	private double height;
	private double width;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double calculateArea() {
		return height * width;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * getWidth() + 2 * getHeight();
	}

}
