package coffeeShop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CoffeShop {

	List<Product> products = new ArrayList<>();
	List<Product> order = new ArrayList<>();

	Scanner input = new Scanner(System.in);

	public void setupProducts() {
		Product coffee = new Product();
		coffee.setName("Coffee");
		coffee.setPrice(5.4);
		products.add(coffee);

		Product tea = new Product();
		tea.setName("Tea");
		tea.setPrice(4.35);
		products.add(tea);

		Product cookie = new Product();
		cookie.setName("Cookie");
		cookie.setPrice(6.7);
		products.add(cookie);

		Product juice = new Product();
		juice.setName("Juice");
		juice.setPrice(2.25);
		products.add(juice);
//		printProduct(coffee);
//		printProduct(tea);
//		printProduct(cookie);
	}

	public void printProduct(Product product) {
		System.out.println(product.getName() + "\t\t" + product.getFormattedPrice());
	}

	public void printAllProducts() {
		System.out.println("\n---------------Products list---------------");
		System.out.println("Product\t\tPrice");
		for (Product product : products) {
			printProduct(product);
		}
		System.out.println();
	}

	public void printOrderProducts() {
		System.out.println("\n---------------Order list---------------");
		System.out.println("Product\t\tPrice");
		double sum = 0;
		for (Product product : order) {
			printProduct(product);
			sum+=product.getPrice();
		}
		System.out.println("\t\t------");
		//System.out.printf("Total cost:\t$%.2f\n", sum);
		DecimalFormat df = new DecimalFormat("$0.00");
		System.out.println("Total cost:\t"+ df.format(sum));
	}

	public int displayMainUserMenu() {
		System.out.println("\n---------------Main menu---------------");
		System.out.println("1) Print the menu items and prices");
		System.out.println("2) Add an item to your order");
		System.out.println("3) Print the items in your order");
		System.out.println("4) Checkout.");
		System.out.println("5) Exit.");

		System.out.print("\nWhat do you want to do? ");
		int select = input.nextInt();
		input.nextLine();

		return select;
	}

	public void userSelectProduct() {
		System.out.println("\n---------------Add products to order ---------------");
		while (true) {
			System.out.print("Enter product name to order: ");
			String orderSelection = input.nextLine();
			if (orderSelection.equalsIgnoreCase("q") )
				break;
			for (Product product : products) {
				if (product.getName().equalsIgnoreCase(orderSelection)) {
					order.add(product);
					System.out.println("Added " + product.getName() + " to your order\n");
					System.out.println("To exit to main menu press \"q\" to order another product type the name");

				}
			}
		}
	}

	public static void main(String[] args) {
		CoffeShop cf = new CoffeShop();
		cf.setupProducts();

		while (true) {

			int userSelection = cf.displayMainUserMenu();

			if (userSelection == 1) {
				cf.printAllProducts();
			} else if (userSelection == 2) {
				cf.userSelectProduct();
			} else if (userSelection == 3) {
				cf.printOrderProducts();
			} else if (userSelection == 5) {
				System.out.println("Thank you for your order");
				System.exit(0);
			} else {
				System.out.println("User input " + userSelection + " is unknown.");
			}
		}

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
