package inheritance;

public abstract class Shape implements Area, Perimeter {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public abstract double calculateArea();
}
