package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Scanner;

public class OrderProductExample {

	public static void main(String[] args) {
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "1111";
		String sql = "Select p.id, p.product_name,  od.order_id, od.quantity_ordered, p.msrp, p.buy_price,  "
				+ "		(p.msrp - p.buy_price) as margin,  (p.msrp - p.buy_price)*od.quantity_ordered as total_margin "
				+ " from products p, orderdetails od " + " where p.id = od.product_id " + " and od.order_id= ? ";
		try (Connection connection = DriverManager.getConnection(dburl, user, password);
				Scanner scanner = new Scanner(System.in);
				PreparedStatement stm = connection.prepareStatement(sql);

		) {
			System.out.print("Enter order number: ");
			int ordId = scanner.nextInt();
			stm.setInt(1, ordId);
			ResultSet result = stm.executeQuery();
			double counter = 0;
			DecimalFormat df = new DecimalFormat("###,#00.00");

			while (result.next()) {
				Integer id = result.getInt("id");
				String product_name = result.getString("product_name");
				int quantity_ordered = result.getInt("quantity_ordered");
				double msrp = result.getDouble("msrp");
				double buy_price = result.getDouble("buy_price");
				double margin = result.getDouble("margin");
				double total_margin = result.getDouble("total_margin");
				counter += total_margin;
				String formattedString = String.format("%2d | %37s | %d | %6.2f | %.2f |  %.2f |  %7.2f |\n", id,
						product_name, quantity_ordered, msrp, buy_price, margin, total_margin);
				System.out.println(formattedString);
			}
			System.out.printf("Total margin:  \t\t\t\t\t\t\t\t|  %.2f |", counter);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
