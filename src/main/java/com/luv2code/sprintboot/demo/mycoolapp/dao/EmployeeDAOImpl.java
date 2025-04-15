package com.luv2code.sprintboot.demo.mycoolapp.dao;

import com.luv2code.sprintboot.demo.mycoolapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        Employee targetEmployee = entityManager.find(Employee.class, theId);
        return targetEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // if id == 0 then insert/save else update
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
