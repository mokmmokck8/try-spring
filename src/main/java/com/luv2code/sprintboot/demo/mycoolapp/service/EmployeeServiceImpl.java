package com.luv2code.sprintboot.demo.mycoolapp.service;

import com.luv2code.sprintboot.demo.mycoolapp.dao.EmployeeDAO;
import com.luv2code.sprintboot.demo.mycoolapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
