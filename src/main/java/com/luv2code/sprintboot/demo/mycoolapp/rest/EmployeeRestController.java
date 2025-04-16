package com.luv2code.sprintboot.demo.mycoolapp.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.sprintboot.demo.mycoolapp.entity.Employee;
import com.luv2code.sprintboot.demo.mycoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// if install spring-boot-starter-data-rest, no need EmployeeRestController and EmployeesService and EmployeeServiceImpl
// its endpoint is http://localhost:8080/employees, which is Entity name add a 's'
// spring-boot-starter-data-rest may implement api using HATEOAS style
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    ObjectMapper objectMapper = new ObjectMapper();

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

        // set id to 0 means to save a new item, instead of update an existed item in DB (id type = int)
        // if id type using wrapper class Integer, need to set id to null instead of 0
        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return theEmployee;
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        Employee targetEmployee = employeeService.findById(employeeId);

        if (targetEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        Employee patchedEmployee = apply(patchPayload, targetEmployee);

        Employee dbEmployee = employeeService.save(patchedEmployee);
        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee targetEmployee) {

        // Convert employee object to a JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(targetEmployee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        employeeNode.setAll(patchNode);

        // convert JSON object node to JAVA object
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee targetEmployee = employeeService.findById(employeeId);

        if (targetEmployee == null) {
            throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
