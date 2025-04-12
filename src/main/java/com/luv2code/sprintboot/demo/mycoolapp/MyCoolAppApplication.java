package com.luv2code.sprintboot.demo.mycoolapp;

import com.luv2code.sprintboot.demo.mycoolapp.dao.StudentDAO;
import com.luv2code.sprintboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/* @SpringBootApplication(
		scanBasePackages = {"com.luv2code.sprintboot.demo.mycoolapp", "com.luv2code.util"}
) */
@SpringBootApplication
public class MyCoolAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCoolAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numberRowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numberRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);

    }


    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id:" + studentId);
        Student myStudent = studentDAO.findById(studentId);

        System.out.println("updating student ...");
        myStudent.setFirstName("John");

        studentDAO.update(myStudent);
        System.out.println("Update student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Duck");

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findAll();

        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "paul@luv2code.com");

        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        int tempStudentId = tempStudent.getId();
        System.out.println("Saved student. Generated id:" + tempStudentId);

        Student myStudent = studentDAO.findById(tempStudentId);

        System.out.println("Found the student" + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 student objects...");
        Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
        Student tempStudent3 = new Student("Leo", "Mok", "leo@luv2code.com");

        // save the student object
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id:" + tempStudent.getId());
    }
}

// SQL
// ALTER TABLE student_tracker.student AUTO_INCREMENT=3000
// TRUNCATE student_tracker.student