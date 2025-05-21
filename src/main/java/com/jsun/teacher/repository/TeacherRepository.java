package com.jsun.teacher.repository;

import com.jsun.teacher.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
    List<Teacher> findByNameContainingIgnoreCase(String name);
    List<Teacher> findBySchoolContainingIgnoreCase(String school);
    List<Teacher> findBySubjectContaining(String subject);
} 