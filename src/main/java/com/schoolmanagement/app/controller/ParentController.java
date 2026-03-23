package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.ParentListProjection;
import com.schoolmanagement.app.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parents")
@CrossOrigin(origins = "*")
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public ResponseEntity<List<ParentListProjection>> getAllParents() {
        List<ParentListProjection> parentList = parentService.getAllParents();
        return ResponseEntity.status(HttpStatus.OK).body(parentList);
    }
}
