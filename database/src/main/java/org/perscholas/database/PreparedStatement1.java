package org.perscholas.database;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatement1 {

	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "1111";
		String sql = "Select * from employees where firstName = ? and lastName = ? ";
		try (Connection connection = DriverManager.getConnection(dburl, user, password);) {
			// Class.forName("com.mysql.cj.jdbc.Driver"); // optional
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter firdt name:");
			String firstName = scanner.nextLine();
			String lastName = scanner.nextLine();
			
			
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, firstName);
			stm.setString(2, lastName);
			ResultSet result = stm.executeQuery();
			while (result.next()) {
				Integer id = result.getInt("id");
				String firstNameRS = result.getString("firstName");
				String lastnameRS = result.getString("lastName");
				String email = result.getString("email");
				System.out.println(id+" | "+firstNameRS + " | " +lastnameRS + " | " +
						email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
