package com.luv2code.sprintboot.demo.mycoolapp.dao;

import com.luv2code.sprintboot.demo.mycoolapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();

    Student findById(Integer Id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
