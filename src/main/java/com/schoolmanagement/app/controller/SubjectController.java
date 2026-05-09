package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.dto.create.CreateSubjectDto;
import com.schoolmanagement.app.entity.Subject;
import com.schoolmanagement.app.repository.SubjectRepository;
import com.schoolmanagement.app.repository.projection.SubjectTeacherListProjection;
import com.schoolmanagement.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //get all subjects and teachers
    @GetMapping("/subjects")
    public ResponseEntity<List<SubjectTeacherListProjection>> findSubjectTeacherList() {
        List<SubjectTeacherListProjection> subjects=subjectService.getSubjectTeacherList();

        return ResponseEntity.status(HttpStatus.OK).body(subjects);
    }

    //create a new subject
    @PostMapping("/subjects")
    public ResponseEntity<Subject> createSubject(@RequestBody CreateSubjectDto createSubjectDto) {

        Subject createdSubject = subjectService.createSubject(createSubjectDto);

        return ResponseEntity.status(HttpStatus.OK).body(createdSubject);
    }
}
