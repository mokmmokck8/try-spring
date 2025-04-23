package com.luv2code.sprintboot.demo.mycoolapp.controller;

import com.luv2code.sprintboot.demo.mycoolapp.model.ThymeleafStudent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeleafStudentController {
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        ThymeleafStudent theStudent = new ThymeleafStudent();

        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") ThymeleafStudent theStudent) {
        System.out.println("theStudent: " + theStudent);
        return "student-confirmation";
    }
}
