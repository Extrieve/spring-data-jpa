package com.extrieve.spring.data.jpa.service;

import com.extrieve.spring.data.jpa.entity.Student;
import com.extrieve.spring.data.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByFirstName(String first_name) {
        return studentRepository.findByFirstName(first_name);
    }

    @Override
    public List<Student> queryStudentByFirstName(String first_name) {
        return studentRepository.findByFirstNameContaining(first_name);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}

