package com.example.rest.api.crud.service;

import com.example.rest.api.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee addEmployee(Employee employee);

    void removeEmployee(int id);
}
