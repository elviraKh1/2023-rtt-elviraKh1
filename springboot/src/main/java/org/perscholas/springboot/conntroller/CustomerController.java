package org.perscholas.springboot.conntroller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    private CustomerDAO customerDAO;

    @GetMapping("/customer/searchbyname")
    public ModelAndView searchCustomer(@RequestParam(required = false) String fName,
                                       @RequestParam(required = false) String lName) {
        ModelAndView response = new ModelAndView("/customer/search");
        log.info("In the customer search controller method search parameters fName: "+fName+" and lName: "+lName);
        if (fName!=null||lName!=null) {
            List<Customer> customers = customerDAO.findByFullName(fName, lName);
            response.addObject("customersVar",customers);
            response.addObject("fName",fName);
            response.addObject("lName",lName);
            for (Customer customer: customers) {
                log.debug("Customer is "+customer);
            }
        }
        return response;
    }

    @GetMapping("/customer/search")
    public ModelAndView searchCustomer(@RequestParam(required = false) String search) {
        ModelAndView response = new ModelAndView("/customer/search");
        log.info("In the customer search controller method search parameter: "+search);
        if (search!=null) {
            List<Customer> customers = customerDAO.findByFirstName(search);
            response.addObject("customersVar",customers);
            response.addObject("search",search);
            for (Customer customer: customers) {
                log.debug("Customer is "+customer);
            }
        }
        return response;
    }

    @GetMapping("/customer/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView("/customer/create");
        log.info("In create customer with NO args");
        return response;
    }

    //    //////arguments spring beans
    @GetMapping("/customer/createSubmit")
    public ModelAndView createCustomerSubmit(CreateCustomerFormBean form) {
        ModelAndView response = new ModelAndView("/customer/create");
        System.out.println("firstName=" + form.getFirstName());
        System.out.println("lastName=" + form.getLastName());
        System.out.println("phone=" + form.getPhone());
        System.out.println("city=" + form.getCity());

        log.info("In create customer with args");

        Customer customer = new Customer();
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setPhone(form.getPhone());
        customer.setCity(form.getCity());
        customerDAO.save(customer);

        return response;
    }


}

