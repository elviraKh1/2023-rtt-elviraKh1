package org.perscholas.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.sequirity.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    public Customer createCustomer(CreateCustomerFormBean form) {
        log.debug("id =" + form.getId());
        log.debug("first name = " + form.getFirstName());
        log.debug("last name" + form.getLastName());
        log.debug("city" + form.getCity());
        log.debug("phone" + form.getPhone());
        log.debug("image url" + form.getImageUrl());

        Customer customer = customerDAO.findById(form.getId());

        if (customer == null) {
            customer = new Customer();
        }
        User user = authenticatedUserService.loadCurrentUser();
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setCity(form.getCity());
        customer.setPhone(form.getPhone());
        customer.setImageUrl(form.getImageUrl());
        customer.setUser(user);

        return customerDAO.save(customer);
    }
}
