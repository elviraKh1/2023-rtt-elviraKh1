package org.perscholas.springboot.service;


import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public void createEmployee(CreateEmployeeFormBean form) {

        log.debug("id =" + form.getId());
        log.debug("first name = " + form.getFirstName());
        log.debug("last name" + form.getLastName());
        log.debug("city" + form.getDepartmentName());


        Employee employee = employeeDAO.findById(form.getId());

        if (employee == null) {
            employee = new Employee();
        }

        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setDepartmentName(form.getDepartmentName());

        employeeDAO.save(employee);

    }
}
