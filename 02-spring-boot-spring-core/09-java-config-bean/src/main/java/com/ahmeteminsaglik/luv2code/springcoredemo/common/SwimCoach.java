package com.ahmeteminsaglik.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

//if using @Bean, then class does not have to use @Component
@Component
public class SwimCoach implements Coach {
    private String explanation;

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName()+" "+this);
        setExplanation("Created from Constructor (which means created by @Component");
    }

    @Override
    public String getDailyWorkout() {
        return "For Swim: Swim 1000 meters as a warm up";
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
