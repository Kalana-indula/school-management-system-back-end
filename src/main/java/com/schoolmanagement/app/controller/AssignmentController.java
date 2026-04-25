package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.AssignmentProjection;
import com.schoolmanagement.app.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentProjection>> getAssignmentList() {

        List<AssignmentProjection> assignmentList = assignmentService.getAssignmentList();
        return ResponseEntity.status(HttpStatus.OK).body(assignmentList);
    }

    @GetMapping("/teachers/{teacherId}/assignments")
    public ResponseEntity<List<AssignmentProjection>> findAssignmentsByTeacher(@PathVariable Long teacherId) {

        List<AssignmentProjection> assignmentList = assignmentService.getAssignmentsByTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(assignmentList);
    }
}
