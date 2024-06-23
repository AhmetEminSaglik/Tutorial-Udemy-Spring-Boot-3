package com.ahmeteminsaglik.luv2code.cruddemo;

import com.ahmeteminsaglik.luv2code.cruddemo.dao.AppDAO;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Instructor;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            findInstructorDetailById(appDAO);
        };
    }

    private void findInstructorDetailById(AppDAO appDAO) {
        int id=3;
        InstructorDetail instructorDetail=appDAO.findInstructorDetailById(id);
        System.out.println("Found Insturctor Detail: "+instructorDetail);
    }

    private void deleteInstructorById(AppDAO appDAO) {
        int id=1;
        appDAO.deleteInstructorById(id);
    }

    private void findInstructorById(AppDAO appDAO) {
        int id=1;
        Instructor instructor=appDAO.findInstructorById(id);
        System.out.println("retrieved instructor : "+instructor);
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
