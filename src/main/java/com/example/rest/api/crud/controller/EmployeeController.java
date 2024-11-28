package com.example.rest.api.crud.controller;

import com.example.rest.api.crud.entity.Employee;
import com.example.rest.api.crud.exception.EmployeeNotFoundException;
import com.example.rest.api.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null){
            throw new EmployeeNotFoundException("There is no employee with id :"+ id);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee theEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(theEmployee, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee theEmployee = employeeService.addEmployee(employee);
        if (theEmployee == null){
            throw new EmployeeNotFoundException("There is no Employee with id : "+ employee.getId());
        }
        return new ResponseEntity<>(theEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public void removeEmployee(@PathVariable int id){
        employeeService.removeEmployee(id);
    }
}
