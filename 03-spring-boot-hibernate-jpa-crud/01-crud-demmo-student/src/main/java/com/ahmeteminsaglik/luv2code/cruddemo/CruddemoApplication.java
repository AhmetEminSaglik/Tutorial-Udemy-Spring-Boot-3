package com.ahmeteminsaglik.luv2code.cruddemo;

import com.ahmeteminsaglik.luv2code.cruddemo.dao.StudentDAO;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createMultipleStudents(studentDAO);
//            createStudent(studentDAO);

            updateStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        studentDAO.deleteAllStudents();
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Getting student with id : " + studentId);
        Student student = studentDAO.findById(studentId);
        System.out.println("Retrieved Student : " + student);
        System.out.println("Deleting Student...");
        studentDAO.delete(studentId);
    }

    private void updateMultipleData(StudentDAO studentDAO) {
        studentDAO.updateAllLastname();
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id : " + studentId);
        Student student = studentDAO.findById(studentId);
        System.out.println("Retrieved Student : " + student);
        System.out.println("Updating Student...");
        student.setFirstName("Scooby");
        studentDAO.update(student);
        System.out.println("Updated Student : " + student);
    }

    private void readAllStudentsByLastName(StudentDAO studentDAO) {
        List<Student> list = studentDAO.findByLastName("aes");
        System.out.println("list size : " + list.size());
        list.forEach(System.out::println);

    }

    private void readAllStudents(StudentDAO studentDAO) {
        List<Student> list = studentDAO.findAll();
        list.forEach(System.out::println);
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Create new Student object...");
        Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");

        System.out.println("Saving the Student... ");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. Generated id: " + tempStudent.getId());

        System.out.println("Retrieving the student with id: " + tempStudent.getId());
        Student student = studentDAO.findById(tempStudent.getId());
        System.out.println("Found The Student : " + student);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        Student tempStudent1 = new Student("Ahmet Emin", "SAGLIK", "ahmeteminsaglik@gmail.com");
        Student tempStudent2 = new Student("AES", "aes", "aes@gmail.com");
        Student tempStudent3 = new Student("Test", "Random", "testrandom@gmail.com");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        Student tempStudent = new Student("Ahmet Emin", "SAGLIK", "ahmeteminsaglik@gmail.com");
        studentDAO.save(tempStudent);
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }

}
