package com.ahmeteminsaglik.luv2code.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    private String firstName;
    private String lastName;
    private  School school;
    private List<Integer> numberList= new ArrayList<>();

    private  void addNumbers(){
        Random random = new Random();
        numberList.add(random.nextInt(100));
        numberList.add(random.nextInt(100));
        numberList.add(random.nextInt(100));
    }
    public Student() {
        addNumbers();
    }

    public Student(String firstName, String lastName, School school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        addNumbers();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", school=" + school +
                '}';
    }
    /*

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
*/
}
