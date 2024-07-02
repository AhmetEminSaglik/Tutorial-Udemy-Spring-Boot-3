package com.ahmeteminsaglik.luv2code.cruddemo;

import com.ahmeteminsaglik.luv2code.cruddemo.dao.AppDAO;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Course;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Instructor;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.InstructorDetail;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Review;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createCourseAndReviews(appDAO);
//            retrieveCourseAndReviews(appDAO);
            deleteCourseAndReviews(appDAO);
        };
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        System.out.println("Delete Course id: " + id);
        appDAO.deleteCourseById(id);
        System.out.println("Done!");


    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseAndReviewsByCourseId(id);
        System.out.println("Retrieved Course  :" + course);
        System.out.println(course.getReviewList());
        System.out.printf("Done!");
    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course course = new Course("Pacman - How To Score One Million Points");

        course.addReview(new Review("Great course ... loved it!"));
        course.addReview(new Review("Cool course, job well done."));
        course.addReview(new Review("What a dumb course, you are an idiot!"));
        System.out.println("Saving the course");
        System.out.println(course);
        System.out.println(course.getReviewList());
        ;
        appDAO.save(course);
    }

    private void deleteCourseById(AppDAO appDAO) {
        int id = 10;
        System.out.println("Course :" + appDAO.findCourseById(id));
        System.out.println("Removing the course...");
        appDAO.deleteCourseById(id);
        System.out.println("Course is removed...");
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;
        Course course = appDAO.findCourseById(id);
        System.out.println("Finding Course : " + course);
        course.setTitle("Piyana Kursu");
        appDAO.update(course);
        course = appDAO.findCourseById(id);
        System.out.println("Retrieved updated course : " + course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Retrieved instructor : " + instructor);
        instructor.setLastName("TESTER");
        appDAO.update(instructor);
        instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor is updated : " + instructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("tempInstructor " + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourseList());
        System.out.println("Done!");
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
