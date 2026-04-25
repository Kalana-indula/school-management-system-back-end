package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.ExamProjection;
import com.schoolmanagement.app.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/exams")
    public ResponseEntity<List<ExamProjection>> getAllExams() {
            List<ExamProjection> exams=examService.getExamList();
            return ResponseEntity.status(HttpStatus.OK).body(exams);
    }

    @GetMapping("/teachers/{teacherId}/exams")
    public ResponseEntity<List<ExamProjection>> getExamsByTeacher(@PathVariable Long teacherId) {
        List<ExamProjection> exams=examService.getExamsByTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(exams);
    }
}
