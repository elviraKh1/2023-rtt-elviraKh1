package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    public Customer findById(Integer id);

    public Customer deleteById(Integer id);


    @Query("select c from Customer c where c.firstName=:firstName")
    public List<Customer> findByFirstName(String firstName);

    @Query("select c from Customer c where c.firstName like :firstName or c.lastName like :lastName ")
    public List<Customer> findByFullName(String firstName, String lastName);

    public List<Customer> findByUserId(Integer userId);
}
