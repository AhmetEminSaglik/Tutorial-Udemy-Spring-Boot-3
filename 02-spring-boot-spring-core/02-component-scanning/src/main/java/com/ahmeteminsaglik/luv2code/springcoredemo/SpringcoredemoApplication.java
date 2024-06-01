package com.ahmeteminsaglik.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*

Here is created when  Coach and CricketCoach were inside the util which is totaly different package
@SpringBootApplication(
        scanBasePackages = {"com.ahmeteminsaglik.luv2code.springcoredemo",
                "com.ahmeteminsaglik.luv2code.util"})
//both packages are added.*/


//if it is default, then it will use the package where it is within subpackages
@SpringBootApplication
public class SpringcoredemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcoredemoApplication.class, args);
    }

}
