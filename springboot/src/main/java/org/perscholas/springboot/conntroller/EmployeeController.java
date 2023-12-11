package org.perscholas.springboot.conntroller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.springboot.database.dao.EmployeeDAO;
import org.perscholas.springboot.database.entity.Employee;
import org.perscholas.springboot.database.entity.User;
import org.perscholas.springboot.formbean.CreateEmployeeFormBean;
import org.perscholas.springboot.sequirity.AuthenticatedUserService;
import org.perscholas.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/employee/create")
    public ModelAndView createEmployee() {
        ModelAndView response = new ModelAndView("employee/create");
        log.info("In create Employee with NO args");
        return response;
    }

    //    //////arguments spring beans
    @GetMapping("/employee/createSubmit")
    public ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean form, BindingResult bindingResult) {
        log.info("######################### In create employee submit #########################");
        ModelAndView response ;

        if (bindingResult.hasErrors()) {
            log.info("######################### In create employee submit -HAS ERRORS #########################");
            response = new ModelAndView("employee/create");
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        Employee e = employeeService.createEmployee(form);
        response = new ModelAndView();
        response.setViewName("redirect:/employee/edit/" + e.getId() + "?success=Employee Saved Successfully");

        return response;
    }

    @GetMapping("/employee/search")
    public ModelAndView search(@RequestParam(required = false) String fName,
                               @RequestParam(required = false) String lName) {
        ModelAndView response = new ModelAndView("employee/search");
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
    public ModelAndView editEmployee(@PathVariable Integer id, @RequestParam(required = false) String success) {
        ModelAndView response = new ModelAndView("employee/create");

        log.info("In edit employee with id = " + id);
        Employee employee = employeeDAO.findById(id);

        if (!StringUtils.isEmpty(success)) {
            response.addObject("success", success);
        }


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

    @GetMapping("/employee/myEmployees")
    public ModelAndView myEmployees() {
        log.info("######################### In my myEmployees #########################");

        // 1) Use the authenticated user service to find the logged in user
        // 2) Create a DAO method that will find by userId
        // 3) use the authenticated user id to find a list of all customers created by this user
        // 4) loop over the customers created and log.debug the customer id and customer last name

        User user =authenticatedUserService.loadCurrentUser();
        log.debug("user id "+user.getId());
        List<Employee> employees = employeeDAO.findByUserId(user.getId());
        log.info("Size employees "+employees.size());
        for (Employee employee: employees) {
            log.debug(employee.toString());
        }
        log.info("######################### end my myEmployees #########################");
        ModelAndView response = new ModelAndView("employee/search");
        response.addObject("employees", employees);
        return response;
    }
}
