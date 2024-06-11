package com.ahmeteminsaglik.luv2code.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    List<String> list;

    @GetMapping("/hello")
    public String sayHello() throws Exception {
        throw new Exception("If you see this, then GlobalExceptionHandler is working perfectly");
//        list.get(0);
//        return "Hello World!";
    }

}
