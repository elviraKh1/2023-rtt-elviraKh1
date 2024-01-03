package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    public Customer findById(Integer id);

    @Transactional
    void deleteById(Integer id);

    @Modifying
    @Transactional
    int deleteByFirstName(String name);

    List<Customer> findByFirstNameOrLastName(String fName, String lName);

    @Query("select c from Customer c where c.firstName=:firstName")
    List<Customer> findByFirstName(String firstName);

    @Query("select c from Customer c where c.firstName like :firstName or c.lastName like :lastName ")
    List<Customer> findByFullName(String firstName, String lastName);

    List<Customer> findByUserId(Integer userId);
}
