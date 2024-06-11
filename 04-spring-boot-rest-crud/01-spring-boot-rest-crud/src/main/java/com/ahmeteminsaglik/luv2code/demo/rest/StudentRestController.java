package com.ahmeteminsaglik.luv2code.demo.rest;

import com.ahmeteminsaglik.luv2code.demo.entity.School;
import com.ahmeteminsaglik.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> theStudents = new ArrayList<>();

    public StudentRestController() {
        theStudents.add(new Student("Ahmet Emin", "SAGLIK",new School("KTU")));
        theStudents.add(new Student("Poornima", "Patel",new School("ITU")));
        theStudents.add(new Student("Mario", "Rossi",new School("ODTU")));
        theStudents.add(new Student("Mary", "Smith",new School("Hacettepe")));
    }

    @GetMapping("/students")
    public List<Student> getStudentList() {
        return theStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return theStudents.get(id);
    }

}
