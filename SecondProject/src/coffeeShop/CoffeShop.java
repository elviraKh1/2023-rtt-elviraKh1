package coffeeShop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoffeShop {

	List<Product> products = new ArrayList<>();

	public void setupProducts() {
		Product coffee = new Product();
		coffee.setName("Coffee");
		coffee.setPrice(5.44);
		products.add(coffee);

		Product tea = new Product();
		tea.setName("Tea");
		tea.setPrice(4.33);
		products.add(tea);

		Product cookie = new Product();
		cookie.setName("Cookie");
		cookie.setPrice(6.77);
		products.add(cookie);

//		printProduct(coffee);
//		printProduct(tea);
//		printProduct(cookie);
	}

	public void printProduct(Product product) {
		System.out.println("Product name is " + product.getName() + " and price: " + product.getPrice());
	}

	public void printAllProducts() {
		for (Product product : products) {
			printProduct(product);
		}
	}

	public static void main(String[] args) {
		CoffeShop cf = new CoffeShop();
		cf.setupProducts();
		cf.printAllProducts();
	}

	public static void main2(String[] args) {
		final double SALES_TAX = 6.3;
		double coffee = 1.5;
		double cappuccino = 2.3;
		double espresso = 1;

		double subtotal = 3 * coffee + 4 * cappuccino + 2 * espresso;
		double totalSale = subtotal + subtotal * SALES_TAX / 100;
		System.out.printf("Format with printf and 2f :  TotalSale is %.2f \n", totalSale);
		DecimalFormat df = new DecimalFormat("$#,###0.00");
		System.out.println("Format with DecimalFormat : TotalSale is " + df.format(totalSale));
	}
}
