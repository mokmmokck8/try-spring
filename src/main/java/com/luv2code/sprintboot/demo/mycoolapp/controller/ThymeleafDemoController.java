package com.luv2code.sprintboot.demo.mycoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafDemoController {
    @GetMapping("/thymeleaf/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());

        // if you use Thymeleaf, it may find a html in src/main/resources/templates/helloworld.html
        return "helloworld";
    }

}
