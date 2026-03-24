package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.ClassListProjection;
import com.schoolmanagement.app.service.ClassEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classes")
@CrossOrigin(origins = "*")
public class ClassEntityController {

    private final ClassEntityService classEntityService;

    @Autowired
    public ClassEntityController(ClassEntityService classEntityService) {
        this.classEntityService = classEntityService;
    }

    @GetMapping
    public ResponseEntity<List<ClassListProjection>> findAllClasses(){

        List<ClassListProjection> classes=classEntityService.getClassList();
        return ResponseEntity.status(HttpStatus.OK).body(classes);
    }
}
