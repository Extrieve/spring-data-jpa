package com.extrieve.spring.data.jpa.service;

import com.extrieve.spring.data.jpa.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public List<Student> getStudentByFirstName(String first_name);

    public List<Student> queryStudentByFirstName(String first_name);

    public Student addStudent(Student student);
}
