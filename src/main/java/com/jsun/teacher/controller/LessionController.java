package com.jsun.teacher.controller;

import com.jsun.teacher.model.Lession;
import com.jsun.teacher.service.LessionService;
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
@RequestMapping("/api/lessions")
@Tag(name = "Lesson Management", description = "APIs for managing lessons")
public class LessionController {
    @Autowired
    private LessionService lessionService;

    @Operation(summary = "Get all lessons", description = "Retrieves a list of all lessons")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved all lessons",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lession.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Lession> getAllLessions() {
        return lessionService.getAllLessions();
    }

    @Operation(summary = "Get lesson by ID", description = "Retrieves a lesson by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the lesson",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lession.class))),
        @ApiResponse(responseCode = "404", description = "Lesson not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Lession> getLessionById(
            @Parameter(description = "ID of the lesson to retrieve", required = true)
            @PathVariable String id) {
        return lessionService.getLessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Search lessons", description = "Search lessons by keyword")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully searched lessons",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lession.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/search")
    public List<Lession> searchLessions(
            @Parameter(description = "Keyword to search for", required = true)
            @RequestParam String keyword) {
        return lessionService.searchLessions(keyword);
    }

    @Operation(summary = "Create new lesson", description = "Creates a new lesson")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully created lesson",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lession.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Lession createLession(
            @Parameter(description = "Lesson object to create", required = true)
            @Valid @RequestBody Lession lession) {
        return lessionService.createLession(lession);
    }

    @Operation(summary = "Update lesson", description = "Updates an existing lesson")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated lesson",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Lession.class))),
        @ApiResponse(responseCode = "404", description = "Lesson not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Lession> updateLession(
            @Parameter(description = "ID of the lesson to update", required = true)
            @PathVariable String id,
            @Parameter(description = "Updated lesson object", required = true)
            @Valid @RequestBody Lession lession) {
        Lession updatedLession = lessionService.updateLession(id, lession);
        if (updatedLession != null) {
            return ResponseEntity.ok(updatedLession);
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
    public ResponseEntity<Void> deleteLession(
            @Parameter(description = "ID of the lesson to delete", required = true)
            @PathVariable String id) {
        lessionService.deleteLession(id);
        return ResponseEntity.ok().build();
    }
} 