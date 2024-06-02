package com.ahmeteminsaglik.luv2code.springcoredemo.rest;

import com.ahmeteminsaglik.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;


    /* inject the bean using the bean id
     * bean id is the function name of the function with annotated @Bean
     * */
    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach, @Qualifier("swimCoach") Coach theAnotherCoach) {
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        System.out.println(myCoach);
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        StringBuilder sb = new StringBuilder();
        System.out.println(myCoach.toString());
        System.out.println(anotherCoach.toString());
        sb.append("myCoach : " + getLastPartOfToString(myCoach.toString()))
                .append("<br>anotherCoach : " + getLastPartOfToString(anotherCoach.toString()))
                .append("<br>Comparing beans : myCoach == anotherCoach, " + (myCoach == anotherCoach));
        return sb.toString();
    }

    private String getLastPartOfToString(String text) {
        String[] arr = text.split("[.]");
        return arr[arr.length - 1];
    }
}
