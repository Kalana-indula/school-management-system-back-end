package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.TeacherProjection;
import com.schoolmanagement.app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<TeacherProjection>> findAllTeachers() {

        List<TeacherProjection> teachersList = teacherService.findAllTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(teachersList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherProjection> findTeacherById(@PathVariable Long id) {
        TeacherProjection teacher= teacherService.findTeacherById(id);
        return ResponseEntity.status(HttpStatus.OK).body(teacher);
    }
}
