package org.perscholas.springboot.database.dao;

import org.junit.jupiter.api.*;
import org.perscholas.springboot.database.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerDAOTest {

    @Autowired
    private CustomerDAO customerDAO;
    private Integer id;
    private String firstName = "Test First 12345";
    private String lastName = "Test Last";
    private String city = "Test City";
    private String phone = "1231313";


    @Test
    @Order(1)
    public void createCustomerTest() {
        //given
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setCity(city);
        customer.setPhone(phone);

        //when
        customer = customerDAO.save(customer);

        //then
        id = customer.getId();
        Assertions.assertNotNull(customer.getId());
        Assertions.assertEquals(firstName, customer.getFirstName());
        Assertions.assertEquals(lastName, customer.getLastName());
        Assertions.assertEquals(city, customer.getCity());
        Assertions.assertEquals(phone, customer.getPhone());
        Assertions.assertNull(customer.getImageUrl());
        Assertions.assertNull(customer.getUser());
    }

    @Test
    @Order(2)
    public void findCustomerByFirstNameOrLastNameTest() {
        //when
        List<Customer> customers = customerDAO.findByFirstNameOrLastName(firstName, null);

        //then
        Assertions.assertEquals(1, customers.size());

        Customer customer = customers.get(0);
        Assertions.assertEquals(firstName, customer.getFirstName());
        Assertions.assertEquals(lastName, customer.getLastName());
        Assertions.assertEquals(city, customer.getCity());
        Assertions.assertEquals(phone, customer.getPhone());
    }

    @Test
    @Order(3)
    public void deleteCustomerByFirstNameTest() {
        int deletedRow = customerDAO.deleteByFirstName(firstName);
        Assertions.assertEquals(1, deletedRow);
    }

    @Test
    @Order(4)
    public void shouldNotExistCustomer() {
        //when
        List<Customer> customers = customerDAO.findByFirstNameOrLastName(firstName, null);

        //then
        Assertions.assertEquals(0, customers.size());
    }
}
