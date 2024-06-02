package com.ahmeteminsaglik.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "For Cricket: Practise fast bowling for 15 minutes";
    }
}
