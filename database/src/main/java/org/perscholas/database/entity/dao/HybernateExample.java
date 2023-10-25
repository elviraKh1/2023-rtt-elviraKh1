package org.perscholas.database.entity.dao;

import java.util.List;

import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class HybernateExample {
	public static void main(String[] args) {
		CustomerDAO cDAO = new CustomerDAO();
		Customer customer = cDAO.findById(103);
		System.out.println(customer.getId()+" | "+ customer.getCustomerName());

		List<Customer> customers = cDAO.findByFirstName("Leslie");
		System.out.println(customers);		
		
		OrderDAO oDAO = new OrderDAO();
		Order order = oDAO.findById(10100);
		System.out.println(order.getId()+" | "+ order.getComments());

		ProductsDAO pDAO = new ProductsDAO();
		Product product = pDAO.findById(23);
		System.out.println(product.getId()+" | "+ product.getProductName());		

		OrderDetailDAO odDAO = new OrderDetailDAO();
		OrderDetail orderDetail = odDAO.findById(1);
		System.out.println(orderDetail.getId()+" | "+ " | "+ orderDetail.getOrderLineNumber());
		

		
	}
}
