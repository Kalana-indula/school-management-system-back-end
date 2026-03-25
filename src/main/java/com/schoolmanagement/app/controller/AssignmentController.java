package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.AssignmentListProjection;
import com.schoolmanagement.app.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignments")
@CrossOrigin(origins = "*")
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping
    public ResponseEntity<List<AssignmentListProjection>> getAssignmentList() {

        List<AssignmentListProjection> assignmentList = assignmentService.getAssignmentList();
        return ResponseEntity.status(HttpStatus.OK).body(assignmentList);
    }
}
