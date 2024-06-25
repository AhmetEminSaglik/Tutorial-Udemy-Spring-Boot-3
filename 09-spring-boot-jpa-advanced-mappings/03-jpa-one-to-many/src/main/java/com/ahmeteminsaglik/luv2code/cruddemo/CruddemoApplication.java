package com.ahmeteminsaglik.luv2code.cruddemo;

import com.ahmeteminsaglik.luv2code.cruddemo.dao.AppDAO;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Course;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Instructor;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructorById(appDAO);
//            deleteInstructorById(appDAO);
//            findInstructorDetailById(appDAO);
//            deleteInstructorDetailById(appDAO);
//            createInstructorWithCourses(appDAO);
            findCoursesForInstructor(appDAO);
        };
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id = 1;

        Instructor tmpInstructor = appDAO.findInstructorById(id);

        System.out.println("tmpInstructor : " + tmpInstructor);
        System.out.println("Finding courses for Instructor id : " + id);
        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        tmpInstructor.setCourseList(courses);
        System.out.println("the associated courses: " + tmpInstructor.getCourseList());
        System.out.println("Done!");

    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com"
                , "Video Games");
        tempInstructor.setInstructorDetail(tempInstructorDetail);


        Course tmpCourse1 = new Course("Learn Unity - Beginner to Ultimate");
        Course tmpCourse2 = new Course("Learn Unreal Engine- Beginner to Ultimate");

        tempInstructor.add(tmpCourse1);
        tempInstructor.add(tmpCourse2);

        System.out.println("Saving instructor : " + tempInstructor);
        System.out.println("The Courses : " + tempInstructor.getCourseList());

        appDAO.save(tempInstructor);
        System.out.println("Done!");

        /*
        Instructor tempInstructor = new Instructor("Ahmet Emin", "Saglik", "ahmeteminsaglik@luv2code.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/@ahmeteminsaglik"
                , "Coding Java");
        tempInstructor.setInstructorDetail(tempInstructorDetail);


        Course tmpCourse1 = new Course("Core Java - Java SE");
        Course tmpCourse2 = new Course("Spring Boot");
        Course tmpCourse3 = new Course("Create Algorithms");

        tempInstructor.add(tmpCourse1);
        tempInstructor.add(tmpCourse2);
        tempInstructor.add(tmpCourse3);

        System.out.println("Saving instructor : " + tempInstructor);
        System.out.println("The Courses : " + tempInstructor.getCourseList());

        appDAO.save(tempInstructor);
        System.out.println("Done!");*/
    }

    private void deleteInstructorDetailById(AppDAO appDAO) {
        int id = 4;
        appDAO.deleteInstructorDetailById(id);
    }

    private void findInstructorDetailById(AppDAO appDAO) {
        int id = 3;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println("Found Insturctor Detail: " + instructorDetail);
    }

    private void deleteInstructorById(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteInstructorById(id);
    }

    private void findInstructorById(AppDAO appDAO) {
        int id = 2;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("retrieved instructor : " + instructor);
    }

    private void createInstructor(AppDAO appDAO) {/*
        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube"
                , "Luv 2 code!!!");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor : " + tempInstructor);
        appDAO.save(tempInstructor);

    */


        Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube"
                , "Guitar!!!");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor : " + tempInstructor);
        appDAO.save(tempInstructor);


    }
}
