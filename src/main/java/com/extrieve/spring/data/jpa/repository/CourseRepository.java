package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    public Page<Course> findByCourseTitleContaining(
            String courseTitle,
            Pageable pageable);
}
