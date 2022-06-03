package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Course;
import com.extrieve.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .courseTitle("Java")
                .courseCredits(3)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseUrl("https://www.udemy.com/course/java-spring-boot-development/")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

}