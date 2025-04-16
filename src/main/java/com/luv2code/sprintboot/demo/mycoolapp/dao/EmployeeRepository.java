package com.luv2code.sprintboot.demo.mycoolapp.dao;

import com.luv2code.sprintboot.demo.mycoolapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Same functionality as EmployeeDAO and EmployeeDAOImpl, use JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
