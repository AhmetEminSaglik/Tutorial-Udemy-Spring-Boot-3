package com.ahmeteminsaglik.luv2code.cruddemo.dao;

import com.ahmeteminsaglik.luv2code.cruddemo.entity.Course;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.Instructor;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);
}
