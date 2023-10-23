package org.perscholas.database;

import java.sql.*;
import java.util.Scanner;

public class FirstConnection {

	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "1111";
		String sql = "Select * from employees";
		try (Connection connection = DriverManager.getConnection(dburl, user, password);) {
			// Class.forName("com.mysql.cj.jdbc.Driver"); // optional
			Scanner scanner = new Scanner(System.in);
			String firstname = scanner.nextLine();
			Statement stm = connection.createStatement();
			ResultSet result = stm.executeQuery(sql+" where firstname='"+firstname+"'");
			while (result.next()) {
				Integer id = result.getInt("id");
				String name = result.getString("firstName");
				String email = result.getString("email");
				System.out.println(id+" | "+name + " | " + email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
