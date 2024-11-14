package com.example.rest.api.crud.controller;

import com.example.rest.api.crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    List<Student> students = new ArrayList<>();

    @PostConstruct
    void loadData() {
        students.add(new Student("first name 1", "last name 1"));
        students.add(new Student("first name 2", "last name 2"));
        students.add(new Student("first name 3", "last name 3"));
        students.add(new Student("first name 4", "last name 4"));
        students.add(new Student("first name 5", "last name 5"));
    }

    @GetMapping(path = "/students")
    public List<Student> getAllStudents() {
        return students;
    }

    @GetMapping(path = "/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.get(id - 1);
    }
}

