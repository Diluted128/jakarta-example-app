package com.example.employeeservice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class EmployeeRepository {
    private final EntityManager entityManager;

    public EmployeeRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employee_wj");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employees =  entityManager.createQuery("SELECT t FROM Employee t", Employee.class)
                .getResultList();
        return employees;
    }

    public List<Employee> getEmployeeById(Long id){
        Employee employee = entityManager.find(Employee.class, id);

        if(employee == null){
            return Collections.emptyList();
        }
        return Collections.singletonList(employee);
    }

    public void addEmployee(Employee employee){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }

    public void updateEmployee(Employee employee){
        Employee employeeToUpdate = entityManager.find(Employee.class, employee.getId());
        EntityTransaction transaction = entityManager.getTransaction();
        employeeToUpdate.setName(employee.getName());
        employeeToUpdate.setSurname(employee.getSurname());
        employeeToUpdate.setOccupation(employee.getOccupation());
        transaction.begin();
        entityManager.flush();
        transaction.commit();
    }
}
