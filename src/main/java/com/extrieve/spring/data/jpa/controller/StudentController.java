package com.extrieve.spring.data.jpa.controller;

import com.extrieve.spring.data.jpa.entity.Student;
import com.extrieve.spring.data.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/students/name/{first_name}")
    public List<Student> getStudentByFirstName(@PathVariable("first_name") String first_name) {
        return studentService.getStudentByFirstName(first_name);
    }
    @PostMapping("/students/name")
    @ResponseBody
    public List<Student> queryStudentByFirstName(@RequestParam(name = "first_name") String first_name) {
        return studentService.queryStudentByFirstName(first_name);
    }


}

