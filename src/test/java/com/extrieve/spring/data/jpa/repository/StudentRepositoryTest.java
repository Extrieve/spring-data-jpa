package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Guardian;
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
//                .guardianName("Michael Doe")
//                .guardianEmail("michael.doe@gmail.com")
//                .guardianMobile("+1-1234567890")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Michael Doe")
                .email("michael.doe@yahoo.com")
                .mobile("+1-1234567890")
                .build();

        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .emailId("john.doe@email.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("John");
        System.out.println(students);
    }

    @Test
    public void printAllStudentsContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("Jo");
        System.out.println(students);
    }

    @Test
    public void printAllStudents() {
//        studentRepository.findAll().forEach(System.out::println);
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }


    @Test
    public void printStudentByEmail() {
        Student student = studentRepository.findByEmailAddress("gmcneilly0@moonfruit.com");
        System.out.println(student);
    }

    @Test
    public void printStudentNameByEmail() {
        String name = studentRepository.findFirstNameByEmailAddress("gmcneilly0@moonfruit.com");
        System.out.println(name);
    }

    @Test
    public void printStudentNameByEmailNative() {
        Student name = studentRepository.getStudentByEmailAddressNative("gmcneilly0@moonfruit.com");
        System.out.println(name.getFirstName());
    }

    @Test
    public void printStudentNameByEmailNativeNamedParam() {
        Student name = studentRepository.getStudentByEmailAddressNativeNamedParam("gmcneilly0@moonfruit.com");
        System.out.println(name.getFirstName());
    }

    @Test
    public void printUpdateStudentFirstNameNative() {
        String firstName = "John";
        studentRepository.updateStudentFirstNameNative(firstName, 1468L);
        Student student = studentRepository.findByStudentId(1468L);
        System.out.println(student.getFirstName());
        System.out.println(student.getFirstName().equals(firstName));
    }
}