package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.LessonProjection;
import com.schoolmanagement.app.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/lessons")
    public ResponseEntity<List<LessonProjection>> getLessonList() {

        List<LessonProjection> lessonList = lessonService.getLessonList();
        return ResponseEntity.status(HttpStatus.OK).body(lessonList);

    }

    @GetMapping("/teachers/{teacherId}/lessons")
    public ResponseEntity<List<LessonProjection>> findLessonsByTeacher(@PathVariable Long teacherId) {
        List<LessonProjection> lessonList=lessonService.getLessonsByTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(lessonList);
    }

    @GetMapping("/students/{studentId}/lessons")
    public ResponseEntity<List<LessonProjection>> findLessonsByStudent(@PathVariable Long studentId) {
        List<LessonProjection> lessonList=lessonService.getLessonsByStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(lessonList);
    }


}
