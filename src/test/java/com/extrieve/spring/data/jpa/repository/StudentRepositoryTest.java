package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@DataJpaTest to test DB without affecting the real DB
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .emailId("john.doe123@gmail.com")
                .guardianName("Michael Doe")
                .guardianEmail("michael.doe@gmail.com")
                .guardianMobile("+1-1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
//        studentRepository.findAll().forEach(System.out::println);
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }

}