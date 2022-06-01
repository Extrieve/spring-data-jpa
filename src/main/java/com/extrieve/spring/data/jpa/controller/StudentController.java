package com.extrieve.spring.data.jpa.controller;

import com.extrieve.spring.data.jpa.entity.Student;
import com.extrieve.spring.data.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // home page
    @GetMapping("/")
    public String home() {
        return "Welcome to the Student Management System";
    }

    // get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
