package com.jsun.teacher.repository;

import com.jsun.teacher.model.Lession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessionRepository extends MongoRepository<Lession, String> {
    List<Lession> findBySubjectContainingIgnoreCase(String subject);
    List<Lession> findByTeacherContainingIgnoreCase(String teacher);
    List<Lession> findByDayOfWeek(String dayOfWeek);
} 