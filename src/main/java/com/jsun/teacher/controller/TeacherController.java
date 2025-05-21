package com.jsun.teacher.controller;

import com.jsun.teacher.model.Teacher;
import com.jsun.teacher.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@Tag(name = "Teacher Management", description = "APIs for managing teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Operation(summary = "Get all teachers", description = "Retrieves a list of all teachers")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all teachers",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @Operation(summary = "Get teacher by ID", description = "Retrieves a teacher by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the teacher",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode = "404", description = "Teacher not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(
            @Parameter(description = "ID of the teacher to retrieve", required = true)
            @PathVariable String id) {
        return teacherService.getTeacherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Search teachers", description = "Search teachers by keyword")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully searched teachers",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/search")
    public List<Teacher> searchTeachers(
            @Parameter(description = "Keyword to search for", required = true)
            @RequestParam String keyword) {
        return teacherService.searchTeachers(keyword);
    }

    @Operation(summary = "Create new teacher", description = "Creates a new teacher")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created teacher",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Teacher createTeacher(
            @Parameter(description = "Teacher object to create", required = true)
            @Valid @RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @Operation(summary = "Update teacher", description = "Updates an existing teacher")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated teacher",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Teacher.class))),
        @ApiResponse(responseCode = "404", description = "Teacher not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(
            @Parameter(description = "ID of the teacher to update", required = true)
            @PathVariable String id,
            @Parameter(description = "Updated teacher object", required = true)
            @Valid @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        if (updatedTeacher != null) {
            return ResponseEntity.ok(updatedTeacher);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete teacher", description = "Deletes a teacher by their ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted teacher"),
        @ApiResponse(responseCode = "404", description = "Teacher not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(
            @Parameter(description = "ID of the teacher to delete", required = true)
            @PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().build();
    }
} 