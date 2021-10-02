package com.dule.spring.data.jpa.app.repository;

import com.dule.spring.data.jpa.app.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
