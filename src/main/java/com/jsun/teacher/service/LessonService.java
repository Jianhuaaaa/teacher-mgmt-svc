package com.jsun.teacher.service;

import com.jsun.teacher.model.Lesson;
import com.jsun.teacher.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> getLessonById(String id) {
        return lessonRepository.findById(id);
    }

    public List<Lesson> searchLessons(String keyword) {
        List<Lesson> bySubject = lessonRepository.findBySubjectContainingIgnoreCase(keyword);
        List<Lesson> byTeacher = lessonRepository.findByTeacherContainingIgnoreCase(keyword);
        
        bySubject.addAll(byTeacher);
        return bySubject;
    }

    public Lesson createLesson(Lesson lesson) {
        lesson.setCreatedOn(new Date());
        lesson.setUpdatedOn(new Date());
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(String id, Lesson lesson) {
        Optional<Lesson> existingLesson = lessonRepository.findById(id);
        if (existingLesson.isPresent()) {
            Lesson updatedLesson = existingLesson.get();
            updatedLesson.setDayOfWeek(lesson.getDayOfWeek());
            updatedLesson.setSubject(lesson.getSubject());
            updatedLesson.setTeacher(lesson.getTeacher());
            updatedLesson.setTime(lesson.getTime());
            updatedLesson.setDate(lesson.getDate());
            updatedLesson.setUpdatedBy(lesson.getUpdatedBy());
            updatedLesson.setUpdatedOn(new Date());
            return lessonRepository.save(updatedLesson);
        }
        return null;
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
} 