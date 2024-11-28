package com.example.rest.api.crud.repository;

import com.example.rest.api.crud.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
