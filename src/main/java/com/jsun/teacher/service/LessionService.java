package com.jsun.teacher.service;

import com.jsun.teacher.model.Lession;
import com.jsun.teacher.repository.LessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LessionService {
    @Autowired
    private LessionRepository lessionRepository;

    public List<Lession> getAllLessions() {
        return lessionRepository.findAll();
    }

    public Optional<Lession> getLessionById(String id) {
        return lessionRepository.findById(id);
    }

    public List<Lession> searchLessions(String keyword) {
        List<Lession> bySubject = lessionRepository.findBySubjectContainingIgnoreCase(keyword);
        List<Lession> byTeacher = lessionRepository.findByTeacherContainingIgnoreCase(keyword);
        
        bySubject.addAll(byTeacher);
        return bySubject;
    }

    public Lession createLession(Lession lession) {
        lession.setCreatedOn(new Date());
        lession.setUpdatedOn(new Date());
        return lessionRepository.save(lession);
    }

    public Lession updateLession(String id, Lession lession) {
        Optional<Lession> existingLession = lessionRepository.findById(id);
        if (existingLession.isPresent()) {
            Lession updatedLession = existingLession.get();
            updatedLession.setDayOfWeek(lession.getDayOfWeek());
            updatedLession.setSubject(lession.getSubject());
            updatedLession.setTeacher(lession.getTeacher());
            updatedLession.setTime(lession.getTime());
            updatedLession.setDate(lession.getDate());
            updatedLession.setUpdatedBy(lession.getUpdatedBy());
            updatedLession.setUpdatedOn(new Date());
            return lessionRepository.save(updatedLession);
        }
        return null;
    }

    public void deleteLession(String id) {
        lessionRepository.deleteById(id);
    }
} 