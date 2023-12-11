package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.firstName like :firstName or e.lastName like :lastName ")
    public List<Employee> findByFullName (String firstName, String lastName);

    public Employee findById (Integer id);

    public List<Employee> findByUserId (Integer userId);

}
