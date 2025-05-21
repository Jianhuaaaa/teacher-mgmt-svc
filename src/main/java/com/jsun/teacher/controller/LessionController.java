package com.jsun.teacher.controller;

import com.jsun.teacher.model.Lession;
import com.jsun.teacher.service.LessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lessions")
public class LessionController {
    @Autowired
    private LessionService lessionService;

    @GetMapping
    public List<Lession> getAllLessions() {
        return lessionService.getAllLessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lession> getLessionById(@PathVariable String id) {
        return lessionService.getLessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Lession> searchLessions(@RequestParam String keyword) {
        return lessionService.searchLessions(keyword);
    }

    @PostMapping
    public Lession createLession(@Valid @RequestBody Lession lession) {
        return lessionService.createLession(lession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lession> updateLession(@PathVariable String id, @Valid @RequestBody Lession lession) {
        Lession updatedLession = lessionService.updateLession(id, lession);
        if (updatedLession != null) {
            return ResponseEntity.ok(updatedLession);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLession(@PathVariable String id) {
        lessionService.deleteLession(id);
        return ResponseEntity.ok().build();
    }
} 