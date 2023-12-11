package org.perscholas.springboot.conntroller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import java.util.List;


// add a label to the existing form input for first name
// add a 2nd form input for last name
// change the controller to accept the new form input for last name as well as first name
// change the query to search by first name OR last name
// change the query to use like for both first name and last name
// make both search fields populate the user input if it was given

@Slf4j
@Controller
public class CustomerController {

//    arguments all request parameters
//    @GetMapping("/customer/create")
//    public ModelAndView createCustomer(@RequestParam(required = false) String firstName,
//                                       @RequestParam(required = false) String lastName,
//                                       @RequestParam(required = false) String phone,
//                                       @RequestParam(required = false) String city) {
//        ModelAndView response = new ModelAndView("/customer/create");
//        System.out.println("firstName="+firstName);
//        System.out.println("lastName="+lastName);
//        System.out.println("phone="+phone);
//        System.out.println("city="+city);
//        return response;
//    }

//    //////arguments spring beans
//    @GetMapping("/customer/create")
//    public ModelAndView createCustomer(CreateCustomerFormBean form) {
//        ModelAndView response = new ModelAndView("/customer/create");
//        System.out.println("firstName=" + form.getFirstName());
//        System.out.println("lastName=" + form.getLastName());
//        System.out.println("phone=" + form.getPhone());
//        System.out.println("city=" + form.getCity());
//        return response;
//    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/customer/searchbyname")
    public ModelAndView searchCustomer(@RequestParam(required = false) String fName,
                                       @RequestParam(required = false) String lName) {
        ModelAndView response = new ModelAndView("customer/search");
        log.info("In the customer search controller method search parameters fName: " + fName + " and lName: " + lName);
        if (StringUtils.isEmpty(fName) || StringUtils.isEmpty(lName)) {
            response.addObject("fName", fName);
            response.addObject("lName", lName);

            if (!StringUtils.isEmpty(fName)) {
                fName = "%" + fName + "%";
            }
            if (!StringUtils.isEmpty(lName)) {
                lName = "%" + lName + "%";
            }
            List<Customer> customers = customerDAO.findByFullName(fName, lName);
            response.addObject("customersVar", customers);
            for (Customer customer : customers) {
                log.debug("Customer is " + customer);
            }
        }
        return response;
    }

    @GetMapping("/customer/search")
    public ModelAndView searchCustomer(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("customer/search");
        log.info("In the customer search controller method search parameter: " + search);
        if (search != null) {
            List<Customer> customers = customerDAO.findByFirstName(search);
            response.addObject("customersVar", customers);
            response.addObject("search", search);
            for (Customer customer : customers) {
                log.debug("Customer is " + customer);
            }
        }
        return response;
    }

    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView("customer/create");
        log.info("In create customer with NO args");
        return response;
    }

    //    //////arguments spring beans
    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(@Valid CreateCustomerFormBean form, BindingResult bindingResult) {
        log.info("######################### In create customer submit #########################");
//        ModelAndView response = new ModelAndView("/customer/create");

        if (bindingResult.hasErrors()) {
            log.info("######################### In create customer submit -HAS ERRORS #########################");
            ModelAndView response = new ModelAndView("customer/create");
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.addObject("errors", bindingResult);

            return response;
        }

        Customer c = customerService.createCustomer(form);
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/customer/edit/" + c.getId() + "?success=Customer Saved Successfully");

        return response;
    }

    @GetMapping("/customer/edit/{id}")
    public ModelAndView editCustomer(@PathVariable int id, @RequestParam(required = false) String success) {
        log.info("######################### In /customer/edit #########################");
        ModelAndView response = new ModelAndView("customer/create");
        log.info("In edit  customer with id " + id);

        Customer customer = customerDAO.findById(id);

        if (!StringUtils.isEmpty(success)) {
            response.addObject("success", success);
        }

        CreateCustomerFormBean form = new CreateCustomerFormBean();
        if (customer != null) {

            form.setFirstName(customer.getFirstName());
            form.setLastName(customer.getLastName());
            form.setCity(customer.getCity());
            form.setPhone(customer.getPhone());
            form.setId(customer.getId());
            form.setImageUrl(customer.getImageUrl());
        } else {
            log.warn(" customer with id " + id + " NOT found");
        }
        response.addObject("form", form);

        return response;
    }

//    @GetMapping("/customer/delete/{id}")
//    public ModelAndView deleteCustomer(@PathVariable int id) {
//        ModelAndView response = new ModelAndView("/customer/search");
//        log.info("In delete  customer with id " + id);
//
//        Customer customer = customerDAO.deleteById(id);
//        CreateCustomerFormBean form = new CreateCustomerFormBean();
//        if (customer != null) {
//            form.setFirstName(customer.getFirstName());
//            form.setLastName(customer.getLastName());
//            form.setCity(customer.getCity());
//            form.setPhone(customer.getPhone());
//            form.setId(customer.getId());
//        }else {
//            log.warn(" customer with id " + id+" NOT found");
//        }
//        response.addObject("form",form);
//
//        return response;
//    }
}

