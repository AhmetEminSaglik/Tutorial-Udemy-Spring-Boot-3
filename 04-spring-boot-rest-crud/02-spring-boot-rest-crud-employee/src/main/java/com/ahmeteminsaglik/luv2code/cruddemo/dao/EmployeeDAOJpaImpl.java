package com.ahmeteminsaglik.luv2code.cruddemo.dao;

import com.ahmeteminsaglik.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
//        TypedQuery<Employee> query = entityManager.createQuery("from Employee where id=:id", Employee.class);
//        query.setParameter("id", id);
//        System.out.println("Typed Querysonucu : " + query.getResultList());
//        TypedQuery<Employee> query =entityManager.createQuery("from Employee where id=:id"u)
        Employee employee = entityManager.find(Employee.class, id);
        System.out.println("hazir query sonucu : " + employee);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) { // if id==0 then insert/save else update
        return entityManager.merge(theEmployee); // add or update employee

        //        Employee employee = entityManager.merge(theEmployee); // add or update employee
        //        return  employee;

    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
