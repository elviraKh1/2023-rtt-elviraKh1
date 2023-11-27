package org.perscholas.springboot.conntroller;

import org.perscholas.springboot.formbean.CreateCustomerFormBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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

    //////arguments spring beans
    @GetMapping("/customer/create")
    public ModelAndView createCustomer(CreateCustomerFormBean form) {
        ModelAndView response = new ModelAndView("/customer/create");
        System.out.println("firstName=" + form.getFirstName());
        System.out.println("lastName=" + form.getLastName());
        System.out.println("phone=" + form.getPhone());
        System.out.println("city=" + form.getCity());
        return response;
    }
}

