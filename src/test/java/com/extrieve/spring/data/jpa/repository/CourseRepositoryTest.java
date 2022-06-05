package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Course;
import com.extrieve.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourse() throws Exception {


        Course course = Course.builder()
                .courseTitle("Python")
                .courseCredits(4)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void saveCourseWithTeacher() throws Exception {
        Course course = Course.builder()
                .courseTitle("Python")
                .courseCredits(4)
                .teacher(Teacher.builder()
                        .teacherName("John")
                        .teacherLastName("Doe")
                        .build())
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printAllCourses() throws Exception {

        List<Course> courses = courseRepository.findAll();

        courses.forEach(course -> System.out.println(course));
    }
}