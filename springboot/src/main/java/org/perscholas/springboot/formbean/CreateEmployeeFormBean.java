package org.perscholas.springboot.formbean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeFormBean {

    private Integer id;
    private String firstName;
    private String lastName;
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
