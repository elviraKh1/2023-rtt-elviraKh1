package org.perscholas.springboot.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateEmployeeFormBean {

    private Integer id;

    @NotEmpty(message="First Name is required")
    @Length(max=45, message = "First name must be less than 45 characters")
    private String firstName;

    @Length(max=45, message = "Last name must be less than 45 characters")
    private String lastName;

    @Length(max=45, message = "Department name must be less than 45 characters")
    private String departmentName;

    @Override
    public String toString() {
        return "CreateEmployeeFormBean{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
