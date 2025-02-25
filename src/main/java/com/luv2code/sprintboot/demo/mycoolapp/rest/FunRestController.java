package com.luv2code.sprintboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${hello.world}")
    private String myGreetingSentence;

    @GetMapping("/")
    public String sayHello() {
        return myGreetingSentence;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi!";
    }
}
