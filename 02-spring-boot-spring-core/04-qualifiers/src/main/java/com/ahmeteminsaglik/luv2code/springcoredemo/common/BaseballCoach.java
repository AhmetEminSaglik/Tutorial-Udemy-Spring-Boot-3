package com.ahmeteminsaglik.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "For Baseball: Spend 30 minutes in batting practise";
    }
}
