package com.dule.spring.data.jpa.app.repository;

import com.dule.spring.data.jpa.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public void findByFirstName(String firstName);

    public void findByFirstNameContaining(String firstName);

    public void findByLastNameNotNull();

    public void findByGuardianName(String guardianName);

    public void findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL based on classes we defined
    @Query("select s from Student s where s.emailId = ?1 ")
    public Student getStudentByEmailAddress(String emailId);

    //Native
    @Query(value = "select * from tbl_student where email_address = ?1", nativeQuery = true)
    public Student getStudentByEmailAddressNative(String emailId);

    //Native Named Param
    @Query(value = "select * from tbl_student where email_address = :emailId", nativeQuery = true)
    public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    //Modifying query
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    public int updateStudentNameByEmailId(String firstName, String emailId);


}
