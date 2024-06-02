package com.ahmeteminsaglik.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {


    //function name is the bean's deafult id
    //to give a bean id add String like following
    @Bean("aquatic")
    public Coach swimCoachFunctionName() {
        return new SwimCoach();
    }

    @Bean("tennisBeanName")
    public Coach tennisCoachFunctionName() {
        return new TennisCoach();
    }

}
