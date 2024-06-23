package com.ahmeteminsaglik.luv2code.cruddemo.dao;

import com.ahmeteminsaglik.luv2code.cruddemo.entity.Instructor;
import com.ahmeteminsaglik.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
}
