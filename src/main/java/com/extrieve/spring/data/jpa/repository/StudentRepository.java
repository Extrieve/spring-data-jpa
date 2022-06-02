package com.extrieve.spring.data.jpa.repository;

import com.extrieve.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    // JPQL example
    @Query("select s from Student s where s.emailId = ?1")
    public Student findByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String findFirstNameByEmailAddress(String emailId);

    // Native Query example
    @Query(value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true)
    public Student getStudentByEmailAddressNative(String emailId);

    // Native Named Parameter example
    @Query(value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true)
    public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

}

