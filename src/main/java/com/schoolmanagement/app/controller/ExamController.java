package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.entity.Exam;
import com.schoolmanagement.app.repository.projection.ExamListProjection;
import com.schoolmanagement.app.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public ResponseEntity<List<ExamListProjection>> getAllExams() {
            List<ExamListProjection> exams=examService.getExamList();
            return ResponseEntity.status(HttpStatus.OK).body(exams);
    }
}
