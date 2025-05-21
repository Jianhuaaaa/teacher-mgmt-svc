package com.jsun.teacher.service;

import com.jsun.teacher.model.Teacher;
import com.jsun.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(String id) {
        return teacherRepository.findById(id);
    }

    public List<Teacher> searchTeachers(String keyword) {
        List<Teacher> byName = teacherRepository.findByNameContainingIgnoreCase(keyword);
        List<Teacher> bySchool = teacherRepository.findBySchoolContainingIgnoreCase(keyword);
        List<Teacher> bySubject = teacherRepository.findBySubjectContaining(keyword);
        
        byName.addAll(bySchool);
        byName.addAll(bySubject);
        return byName;
    }

    public Teacher createTeacher(Teacher teacher) {
        teacher.setCreatedOn(new Date());
        teacher.setUpdatedOn(new Date());
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(String id, Teacher teacher) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(id);
        if (existingTeacher.isPresent()) {
            Teacher updatedTeacher = existingTeacher.get();
            updatedTeacher.setName(teacher.getName());
            updatedTeacher.setGender(teacher.getGender());
            updatedTeacher.setAge(teacher.getAge());
            updatedTeacher.setSubject(teacher.getSubject());
            updatedTeacher.setSchool(teacher.getSchool());
            updatedTeacher.setEducation(teacher.getEducation());
            updatedTeacher.setLevel(teacher.getLevel());
            updatedTeacher.setServiceYears(teacher.getServiceYears());
            updatedTeacher.setBaseSalary(teacher.getBaseSalary());
            updatedTeacher.setSubjectFee(teacher.getSubjectFee());
            updatedTeacher.setHeadTeacher(teacher.getHeadTeacher());
            updatedTeacher.setPay(teacher.getPay());
            updatedTeacher.setRole(teacher.getRole());
            updatedTeacher.setUpdatedBy(teacher.getUpdatedBy());
            updatedTeacher.setUpdatedOn(new Date());
            return teacherRepository.save(updatedTeacher);
        }
        return null;
    }

    public void deleteTeacher(String id) {
        teacherRepository.deleteById(id);
    }
} 