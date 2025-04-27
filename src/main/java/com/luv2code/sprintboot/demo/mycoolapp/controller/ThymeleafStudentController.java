package com.luv2code.sprintboot.demo.mycoolapp.controller;

import com.luv2code.sprintboot.demo.mycoolapp.model.ThymeleafStudent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ThymeleafStudentController {

    // import config values form application.properties
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        ThymeleafStudent theStudent = new ThymeleafStudent();

        theModel.addAttribute("student", theStudent);
//        theModel.addAttribute("countries", countries);
//        theModel.addAttribute("languages", languages);
//        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@Valid @ModelAttribute("student") ThymeleafStudent theStudent, BindingResult theBindingResults) {
        System.out.println("theStudent: " + theStudent);
        System.out.println("BindingResults: " + theBindingResults);
        
        if (theBindingResults.hasErrors()) {
            return "student-form";
        } else {
            System.out.println("theStudent: " + theStudent);
            return "student-confirmation";
        }

    }
}
