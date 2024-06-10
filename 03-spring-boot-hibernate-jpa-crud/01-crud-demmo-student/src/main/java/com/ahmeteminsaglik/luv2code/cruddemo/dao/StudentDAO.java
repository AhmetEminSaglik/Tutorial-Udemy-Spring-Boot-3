package com.ahmeteminsaglik.luv2code.cruddemo.dao;

import com.ahmeteminsaglik.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    // to increate auto increment to 3000 :(SQL COMMAND)  ALTER TABLE student AUTO_INCREMENT =3000
    // to reset auto increment to 1  :(SQL COMMAND) TRUNCATE student;

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);
}
