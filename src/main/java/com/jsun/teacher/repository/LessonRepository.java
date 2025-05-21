package com.jsun.teacher.repository;

import com.jsun.teacher.model.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends MongoRepository<Lesson, String> {
    List<Lesson> findBySubjectContainingIgnoreCase(String subject);
    List<Lesson> findByTeacherContainingIgnoreCase(String teacher);
    List<Lesson> findByDayOfWeek(String dayOfWeek);
} 