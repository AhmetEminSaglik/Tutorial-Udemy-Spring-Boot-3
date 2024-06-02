package com.ahmeteminsaglik.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "For Tennis: Practise fast bowling for 15 minutes";
    }
}
