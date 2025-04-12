package com.luv2code.sprintboot.demo.mycoolapp.rest;

import com.luv2code.sprintboot.demo.mycoolapp.entity.StudentPOJO;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<StudentPOJO> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new StudentPOJO("a", "b"));
        theStudents.add(new StudentPOJO("a1", "b"));
        theStudents.add(new StudentPOJO("a2", "b"));
    }

    @GetMapping("/students")
    public List<StudentPOJO> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public StudentPOJO getStudent(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("student id not found: " + studentId);
        }
        return theStudents.get(studentId);
    }
}
