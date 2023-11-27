package org.perscholas.springboot.conntroller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//create an employee table with following columns: id, firstname, lastname,departmentname
//create an entity and a dao for the employee table
//create controller for the employee table
//create a form bean for the employee table
//create a html page with the form on it
@Slf4j
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/employee/create")
    public ModelAndView createEmployee() {
        ModelAndView response = new ModelAndView("/employee/create");
        log.info("In create Employee with NO args");
        return response;
    }

    //    //////arguments spring beans
    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(CreateEmployeeFormBean form) {
        ModelAndView response = new ModelAndView("/employee/create");
        System.out.println("firstName=" + form.getFirstName());
        System.out.println("lastName=" + form.getLastName());
        System.out.println("departmentName=" + form.getDepartmentName());

        log.info("In create customer with args");

        Employee employee = new Employee();
        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setDepartmentName(form.getDepartmentName());
        employeeDAO.save(employee);

        return response;
    }
}
