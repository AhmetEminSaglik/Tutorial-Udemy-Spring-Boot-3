package com.ahmeteminsaglik.luv2code.cruddemo.dao;

import com.ahmeteminsaglik.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
