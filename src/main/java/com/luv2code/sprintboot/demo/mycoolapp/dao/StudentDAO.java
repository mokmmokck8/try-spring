package com.luv2code.sprintboot.demo.mycoolapp.dao;

import com.luv2code.sprintboot.demo.mycoolapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer Id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
