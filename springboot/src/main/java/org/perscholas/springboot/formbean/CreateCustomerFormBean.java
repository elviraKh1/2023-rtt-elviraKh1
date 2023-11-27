package org.perscholas.springboot.formbean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;
@Getter
@Setter
public class CreateCustomerFormBean {
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
}
