package org.perscholas.springboot.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateCustomerFormBean {

    private Integer id;

    @NotEmpty(message="First Name is required")
    @Length(max=45, message = "First name must be less than 45 characters")
    private String firstName;

    @NotEmpty(message="Last Name is required")
    @Length(max=45, message = "Last name must be less than 45 characters")
    private String lastName;


    @Length(max=45, message = "Phone must be less than 45 characters")
    private String phone;

    @NotEmpty(message="City is required")
    @Length(max=45, message = "City must be less than 45 characters")
    private String city;

    private String imageUrl;

}
