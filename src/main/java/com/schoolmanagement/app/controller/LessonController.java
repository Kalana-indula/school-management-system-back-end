package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.LessonListProjection;
import com.schoolmanagement.app.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
@CrossOrigin(origins = "*")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public ResponseEntity<List<LessonListProjection>> getLessonList() {

        List<LessonListProjection> lessonList = lessonService.getLessonList();
        return ResponseEntity.status(HttpStatus.OK).body(lessonList);

    }
}
