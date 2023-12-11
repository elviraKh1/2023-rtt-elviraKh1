package org.perscholas.springboot.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//id, firstname, lastname,departmentname
@Table(name="employees")
@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="departmentname")
    private String departmentName;

    @Column(name="user_id")
    private Integer userId;

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", userId=" + userId + '}';
    }
}

