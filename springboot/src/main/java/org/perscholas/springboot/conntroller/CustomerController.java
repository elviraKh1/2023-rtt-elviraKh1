package org.perscholas.springboot.conntroller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.perscholas.springboot.database.dao.CustomerDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.perscholas.springboot.sequirity.AuthenticatedUserService;
import org.perscholas.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

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

    @GetMapping("/customer/myCustomers")
    public ModelAndView myCustomers() {
        log.info("######################### In my myCustomers #########################");

        // 1) Use the authenticated user service to find the logged in user
        // 2) Create a DAO method that will find by userId
        // 3) use the authenticated user id to find a list of all customers created by this user
        // 4) loop over the customers created and log.debug the customer id and customer last name

        User user = authenticatedUserService.loadCurrentUser();
        log.debug("user id " + user.getId());
        List<Customer> customers = customerDAO.findByUserId(user.getId());
        log.info("Size employees " + customers.size());
        for (Customer customer : customers) {
            log.debug(customer.toString());
        }
        log.info("######################### end my myCustomers #########################");
        ModelAndView response = new ModelAndView("customer/search");
        response.addObject("customers", customers);
        return response;
    }

    @GetMapping("/customer/detail/")
    public ModelAndView viewCustomer(@RequestParam Integer customerId) {
        log.info("######################### In /customer/detail #########################");
        ModelAndView response = new ModelAndView("customer/detail");
        log.info("+++++++++++++++++In edit  customer with id " + customerId);

        Customer customer = customerDAO.findById(customerId);
        if (customerId == null) {
            log.info("customer with id " + customerId + " not found");
            response.setViewName("redirect:/error/404");
            return response;
        }

        response.addObject("customer", customer);
        return response;
    }

    @GetMapping("/customer/fileupload")
    public ModelAndView fileUpload(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("customer/fileupload");
        log.info(" In fileupload ");
        Customer customer =customerDAO.findById(id);
        response.addObject("customer", customer);
        return response;
    }

    @PostMapping("/customer/fileUploadSubmit")
    public ModelAndView fileUploadSubmit(@RequestParam("file") MultipartFile file, @RequestParam Integer id) {
        ModelAndView response = new ModelAndView("redirect:/customer/detail/?customerId="+id);
        log.info("+++++++++++++++++++ In fileupload +++++++++++++++++++++++++");
        log.info(" In fileupload name " + file.getName());
        log.info(" In fileupload size " + file.getSize());

// Get the file and save it somewhere -1 example
//        try {
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get("./src/main/webapp/pub/images/" + file.getOriginalFilename());
//            Files.write(path, bytes);

        Customer customer =customerDAO.findById(id);
//        response.addObject("customer", customer);

// Get the file and save it somewhere  - 2 example
        File f = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
        try (OutputStream outputStream = new FileOutputStream(f.getAbsolutePath())) {
            IOUtils.copy(file.getInputStream(), outputStream);
            customer.setImageUrl("/pub/images/"+file.getOriginalFilename());
            customerDAO.save(customer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}

