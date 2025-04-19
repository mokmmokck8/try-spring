package com.luv2code.sprintboot.demo.mycoolapp.dao;

import com.luv2code.sprintboot.demo.mycoolapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Same functionality as EmployeeDAO and EmployeeDAOImpl, use JpaRepository
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
