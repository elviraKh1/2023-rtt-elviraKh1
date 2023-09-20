package coffeeShop;

import java.text.DecimalFormat;

public class Product {

	private String name;
	private double price;
	
	public Product() {
	}
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public String getFormattedPrice() {
		DecimalFormat df = new DecimalFormat("$0.00");
		return df.format(price);
	}

	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
