package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.dto.create.GradeDto;
import com.schoolmanagement.app.entity.Grade;
import com.schoolmanagement.app.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class GradeController {

    private GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/grades")
    public ResponseEntity<Grade> createGrade(@RequestBody GradeDto gradeDto) {
        Grade createdGrad=gradeService.createGrade(gradeDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdGrad);
    }

    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return ResponseEntity.status(HttpStatus.OK).body(grades);
    }
}
