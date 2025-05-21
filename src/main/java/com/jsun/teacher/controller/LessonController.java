package com.jsun.teacher.controller;

import com.jsun.teacher.model.Lesson;
import com.jsun.teacher.service.LessonService;
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
@RequestMapping("/api/lessons")
@Tag(name = "Lesson Management", description = "APIs for managing lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Operation(summary = "Get all lessons", description = "Retrieves a list of all lessons")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all lessons",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lesson.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @Operation(summary = "Get lesson by ID", description = "Retrieves a lesson by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the lesson",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lesson.class))),
        @ApiResponse(responseCode = "404", description = "Lesson not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(
            @Parameter(description = "ID of the lesson to retrieve", required = true)
            @PathVariable String id) {
        return lessonService.getLessonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Search lessons", description = "Search lessons by keyword")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully searched lessons",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lesson.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/search")
    public List<Lesson> searchLessons(
            @Parameter(description = "Keyword to search for", required = true)
            @RequestParam String keyword) {
        return lessonService.searchLessons(keyword);
    }

    @Operation(summary = "Create new lesson", description = "Creates a new lesson")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created lesson",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lesson.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Lesson createLesson(
            @Parameter(description = "Lesson object to create", required = true)
            @Valid @RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @Operation(summary = "Update lesson", description = "Updates an existing lesson")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated lesson",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lesson.class))),
        @ApiResponse(responseCode = "404", description = "Lesson not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateLesson(
            @Parameter(description = "ID of the lesson to update", required = true)
            @PathVariable String id,
            @Parameter(description = "Updated lesson object", required = true)
            @Valid @RequestBody Lesson lesson) {
        Lesson updatedLesson = lessonService.updateLesson(id, lesson);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete lesson", description = "Deletes a lesson by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully deleted lesson"),
        @ApiResponse(responseCode = "404", description = "Lesson not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(
            @Parameter(description = "ID of the lesson to delete", required = true)
            @PathVariable String id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.ok().build();
    }
} 