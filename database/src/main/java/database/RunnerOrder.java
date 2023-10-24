package database;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetails;
import org.perscholas.database.entity.Product;
import org.perscholas.database.entity.dao.CustomerDAO;
import org.perscholas.database.entity.dao.OrderDAO;
import org.perscholas.database.entity.dao.ProductsDAO;

public class RunnerOrder {

	private OrderDAO orderDAO = new OrderDAO();

	private List<Order> getOrdersByCustomer(int customerId) {
		List<Order> orders = orderDAO.findByCustomerId(customerId);
		System.out.println("--------Orders By Customer id----------");
		System.out.println(orders.size()+ " records were found in database ");
		System.out.println(orders);
		return orders;
	}

	public static void main(String[] args) {
		RunnerOrder runner = new RunnerOrder();
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Enter customer id: ");
//		int customerId = scanner.nextInt();
//		System.out.println();
//		scanner.close();
//		
//		runner.getOrdersByCustomer(customerId);
//		runner.createOrderByCustomerId(customerId);
//		runner.queryOrder();
		runner.queryProduct();
	}
	
	public void queryOrder() {
		Order o =orderDAO.findById(10100);
		Customer c = o.getCustomer();
		System.out.println("Order "+ o.getId() + " was made by customer "+c.getCustomerName());
		
		List<Order> orders = c.getOrders();
		System.out.println(orders);
	
	}

	public void queryProduct() {
		ProductsDAO productDAO = new ProductsDAO();
		Product product = productDAO.findById(1);
		System.out.println(product);
		
		List<OrderDetails> od = product.getOrdersDetail();
		System.out.println(od);
	
	}
	
	
	private void createOrderByCustomerId(int customerId) {
		CustomerDAO cdao = new CustomerDAO();
		Customer customer = cdao.findById(customerId);
		if (customer != null) {
			Order order = new Order();
			order.setCustomerId(customerId);
			order.setOrderDate(new Date());
			order.setRequiredDate(new Date());
			order.setStatus("In process");
			order.setComments("test for Hibernate ");
			System.out.println("--------Order created By Customer id----------");
			System.out.println("order id before insert is "+order.getId());
			orderDAO.save(order);
			System.out.println("order id after insert is "+order.getId());
		} else {
			System.out.println("Customer with id "+customerId+" doesnt find in DB");
		}
	}

}
