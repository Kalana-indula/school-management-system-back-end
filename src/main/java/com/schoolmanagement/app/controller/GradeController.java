package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.dto.GradeDto;
import com.schoolmanagement.app.entity.Grade;
import com.schoolmanagement.app.service.GradeService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Grade> createGrade(GradeDto gradeDto) {
        Grade createdGrad=gradeService.createGrade(gradeDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdGrad);
    }
}
