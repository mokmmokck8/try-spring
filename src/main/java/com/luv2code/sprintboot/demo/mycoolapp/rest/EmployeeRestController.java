package com.luv2code.sprintboot.demo.mycoolapp.rest;

import com.luv2code.sprintboot.demo.mycoolapp.entity.Employee;
import com.luv2code.sprintboot.demo.mycoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id = " + employeeId + " not found");
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // set id to 0 means to save a new item, instead of update an existed item in DB
        theEmployee.setId(0);
        
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }
}
