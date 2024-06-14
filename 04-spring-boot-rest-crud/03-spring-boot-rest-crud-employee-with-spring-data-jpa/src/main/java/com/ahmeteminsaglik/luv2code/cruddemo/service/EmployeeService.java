package com.ahmeteminsaglik.luv2code.cruddemo.service;

import com.ahmeteminsaglik.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);}
