package com.test.project;

import com.test.hib.controller.FindUserHQL;

public class Runner {
    public static void main(String[] args) {
        FindUserHQL u = new FindUserHQL();
        u.findUser();
        u.findUserSelect();
        u.getRecordById();
        u.getRecords();
        u.getMAXSalary();
        u.getMAXSalaryGroupBy();
        u.getNamedQuery();


    }
}