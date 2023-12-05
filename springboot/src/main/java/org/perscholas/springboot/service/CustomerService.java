package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public void createCustomer(CreateCustomerFormBean form) {
        log.debug("id =" + form.getId());
        log.debug("first name = " + form.getFirstName());
        log.debug("last name" + form.getLastName());
        log.debug("city" + form.getCity());
        log.debug("phone" + form.getPhone());

        Customer customer = customerDAO.findById(form.getId());

        if (customer == null) {
            customer = new Customer();
        }

        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setCity(form.getCity());
        customer.setPhone(form.getPhone());

        customerDAO.save(customer);
    }
}
