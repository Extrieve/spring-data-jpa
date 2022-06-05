package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Course;
import com.extrieve.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

        courses.forEach(System.out::println);
    }

    @Test
    public void findAllPaginatedCourses() throws Exception {

        Pageable firstPagewith10 =
                PageRequest.of(0, 10, Sort.by("courseId").ascending());

        List<Course> courses = courseRepository.findAll(firstPagewith10).getContent();

        Long totalElements = (long) courses.size();
        Long totalPages = courseRepository.count() / 10;

        System.out.println("Total elements: " + totalElements);
        System.out.println("Total pages: " + totalPages);

        courses.forEach(System.out::println);
    }

    @Test
    public void findAllPaginatedByCourseTitle() throws Exception {

        Pageable sortByCourseTitle =
                PageRequest.of(0, 10, Sort.by("courseTitle").ascending());

        Pageable sortByCourseTitleAndCourseCredit =
                PageRequest.of(0, 10, Sort.by("courseTitle").ascending().and(Sort.by("courseCredits").descending()));

        List<Course> courses = courseRepository.findAll(sortByCourseTitle).getContent();

        courses.forEach(System.out::println);

    }

    @Test
    public void findByCourseTitleContaining(){

        Pageable firstPageWith10 = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByCourseTitleContaining("Python", firstPageWith10).getContent();

        courses.forEach(System.out::println);
    }
}