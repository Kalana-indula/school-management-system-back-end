package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.entity.Teacher;
import com.schoolmanagement.app.repository.projection.TeacherListProjection;
import com.schoolmanagement.app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@CrossOrigin(origins = "*")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //create new teacher
    @GetMapping
    public ResponseEntity<List<TeacherListProjection>> findAllTeachers() {

        List<TeacherListProjection> teachersList = teacherService.findAllTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(teachersList);

    }
}
