package database;

import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.dao.CustomerDAO;

import java.util.List;

public class CreataAndUpdateExample {
	private CustomerDAO customerDAO = new CustomerDAO();

	public void insertCustomerExample() {
		Customer customer = new Customer();

		customer.setCustomerName("Diamond ltd");
		customer.setContactFirstName("Adam");
		customer.setContactLastName("Smith");
		customer.setCity("Denver");
		customer.setAddressLine1("1234 Oak str");
		customer.setAddressLine2("B1");
		customer.setPhone(null);
		customer.setCountry("USA");
		customer.setPostalCode("11223");
		customer.setState("New-York");
		customer.setCreditLimit(12000.0);
		customer.setPhone("123-123-934");
		System.out.println("Customer id before insert " + customer.getId());
		customerDAO.save(customer);
		System.out.println("Customer id after insert " + customer.getId());

	}

	public void updateCustomerExample() {
		Customer customer = customerDAO.findById(52782);
		if (customer != null) {
			System.out.println("Customer id before update " + customer);
			customer.setCustomerName("Diamond ltd updated");
			customer.setContactFirstName("Adam  updated");
			customer.setContactLastName("Smith  updated");
			customer.setCity("Denver");
			customer.setAddressLine1("1234 Oak str");
			customer.setAddressLine2("B1");
			customer.setCountry("USA");
			customer.setPostalCode("11223");
			customer.setState("New-York");
			customer.setCreditLimit(34567.0);
			customer.setPhone("111-22-3333");
			customerDAO.save(customer);
			System.out.println("Customer id after update" + customer);
		} else {
			System.out.println("Customer does not exists");
		}
	}

	public void listQuery() {
		List<Customer> customers = customerDAO.findByFirstName("Afdam");
		System.out.println("We found "+ customers.size() + " records in DB ");
	
	}
	
	public static void main(String[] args) {
		CreataAndUpdateExample caue = new CreataAndUpdateExample();
//		caue.insertCustomerExample();
//		caue.updateCustomerExample();
		caue.listQuery();
	}
}
