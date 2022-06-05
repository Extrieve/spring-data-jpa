package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Course;
import com.extrieve.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() throws Exception {

        Course course = Course.builder()
                .courseTitle("Python")
                .courseCredits(4)
                .build();

        Teacher teacher = Teacher
                .builder()
                .teacherName("John").
                teacherLastName("Doe")
//                .courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }

    @Test
    public void fetchAllTeachers() throws Exception {

            List<Teacher> teachers = teacherRepository.findAll();

            teachers.forEach(teacher -> System.out.println(teacher));
    }

}