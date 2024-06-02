package com.ahmeteminsaglik.luv2code.springcoredemo.rest;

import com.ahmeteminsaglik.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    // @Qualifier with Constructor injection
    @Autowired
//    public DemoController(@Qualifier("trackCoach") Coach theCoach) {
    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
//    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
//    public DemoController(@Qualifier("tennisCoach")Coach theCoach) {
        this.myCoach = theCoach;
    }

/*
    // @Qualifier with Setter injection
    @Autowired
//    public void setMyCoach(@Qualifier("baseballCoach") Coach theCoach) {
//    public void setMyCoach(@Qualifier("cricketCoach") Coach theCoach) {
    public void setMyCoach(@Qualifier("tennisCoach") Coach theCoach) {
//    public void doSomeStuff(Coach theCoach) {
        myCoach = theCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
