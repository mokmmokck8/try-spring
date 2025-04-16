package com.luv2code.sprintboot.demo.mycoolapp.service;

import com.luv2code.sprintboot.demo.mycoolapp.dao.EmployeeRepository;
import com.luv2code.sprintboot.demo.mycoolapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    private final EmployeeDAO employeeDAO;
//
//    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
//        this.employeeDAO = employeeDAO;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeDAO.findAll();
//    }
//
//    @Override
//    public Employee findById(int theId) {
//        return employeeDAO.findById(theId);
//    }
//
//    @Override
//    @Transactional
//    public Employee save(Employee theEmployee) {
//        return employeeDAO.save(theEmployee);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(int theId) {
//        employeeDAO.deleteById(theId);
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);

        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Cannot find Employee id - " + employeeId);
        }
        return theEmployee;
    }

    // use employeeRepository no need to add @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
