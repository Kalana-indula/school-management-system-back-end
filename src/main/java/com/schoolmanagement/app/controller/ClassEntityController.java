package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.ClassProjection;
import com.schoolmanagement.app.service.ClassEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ClassEntityController {

    private final ClassEntityService classEntityService;

    @Autowired
    public ClassEntityController(ClassEntityService classEntityService) {
        this.classEntityService = classEntityService;
    }

    @GetMapping("/classes")
    public ResponseEntity<List<ClassProjection>> findAllClasses(){

        List<ClassProjection> classes=classEntityService.getClassList();
        return ResponseEntity.status(HttpStatus.OK).body(classes);
    }

    @GetMapping("/teachers/{teacherId}/classes")
    public ResponseEntity<List<ClassProjection>> findAllClassesByTeacher(@PathVariable Long teacherId){
        List<ClassProjection> classes=classEntityService.getClassesByTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(classes);
    }
}
