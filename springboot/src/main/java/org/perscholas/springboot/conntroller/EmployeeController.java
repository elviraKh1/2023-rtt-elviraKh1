package org.perscholas.springboot.conntroller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.perscholas.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @Autowired
    private EmployeeService employeeService;

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

        log.info("In create employee with args " + form);

        employeeService.createEmployee(form);
//        Employee employee = new Employee();
//        employee.setFirstName(form.getFirstName());
//        employee.setLastName(form.getLastName());
//        employee.setDepartmentName(form.getDepartmentName());
//        employeeDAO.save(employee);

        return response;
    }

    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String fName,
                               @RequestParam(required = false) String lName) {
        ModelAndView response = new ModelAndView("/employee/search");
        log.info("In the employee search controller method search parameters fName: " + fName + " and lName: " + lName);
        if (StringUtils.isEmpty(fName) || StringUtils.isEmpty(lName)) {
            response.addObject("fName", fName);
            response.addObject("lName", lName);

            if (!StringUtils.isEmpty(fName)) {
                fName = "%" + fName + "%";
            }
            if (!StringUtils.isEmpty(lName)) {
                lName = "%" + lName + "%";
            }
            List<Employee> employees = employeeDAO.findByFullName(fName, lName);
            response.addObject("employees", employees);
            for (Employee employee : employees) {
                log.debug("Employee is " + employee);
            }
        }
        return response;
    }

    @GetMapping("/employee/edit/{id}")
    public ModelAndView editEmployee(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("/employee/create");

        log.info("In edit employee with id = " + id);
        Employee employee = employeeDAO.findById(id);

        CreateEmployeeFormBean form = new CreateEmployeeFormBean();
        if (employee != null) {
            form.setFirstName(employee.getFirstName());
            form.setLastName(employee.getLastName());
            form.setDepartmentName(employee.getDepartmentName());
            form.setId(employee.getId());
        } else {
            log.warn(" employee with id " + id + " NOT found");
        }
        response.addObject("form", form);

        return response;
    }
}
