package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.SubjectRepository;
import com.schoolmanagement.app.repository.projection.SubjectTeacherListProjection;
import com.schoolmanagement.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
@CrossOrigin(origins = "*")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //get all subjects and teachers
    @GetMapping
    public ResponseEntity<List<SubjectTeacherListProjection>> findSubjectTeacherList() {
        List<SubjectTeacherListProjection> subjects=subjectService.getSubjectTeacherList();

        return ResponseEntity.status(HttpStatus.OK).body(subjects);
    }
}
