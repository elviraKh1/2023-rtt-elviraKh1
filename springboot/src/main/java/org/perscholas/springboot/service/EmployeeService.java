package org.perscholas.springboot.service;


import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Customer;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.perscholas.springboot.sequirity.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    AuthenticatedUserService authenticatedUserService;

    public Employee createEmployee(CreateEmployeeFormBean form) {

        log.debug("id =" + form.getId());
        log.debug("first name = " + form.getFirstName());
        log.debug("last name" + form.getLastName());
        log.debug("city" + form.getDepartmentName());


        Employee employee = employeeDAO.findById(form.getId());

        if (employee == null) {
            employee = new Employee();

            User user =authenticatedUserService.loadCurrentUser();
            employee.setUserId(user.getId());
        }

        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setDepartmentName(form.getDepartmentName());

        return employeeDAO.save(employee);

    }
}
