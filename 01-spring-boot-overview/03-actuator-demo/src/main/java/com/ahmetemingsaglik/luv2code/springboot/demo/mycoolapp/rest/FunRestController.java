package com.ahmetemingsaglik.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //expose
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello world coach "+coachName+". What's up?";
    }

    @GetMapping("/team")
    public String sayHelloToTeam() {
        return "Hello to my Team coach <b>"+teamName+"</b>";
    }
    @GetMapping("/fortune")
    public String getDailyFourtune(){
        return "Today is your lucky day.";
    }
}
