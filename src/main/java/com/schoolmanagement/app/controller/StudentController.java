package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.StudentProjection;
import com.schoolmanagement.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentProjection>> findAllStudents() {

        List<StudentProjection> studentList = studentService.findAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(studentList);

    }

//    get a single student by id
    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentProjection> findStudentById(@PathVariable Long studentId) {
        StudentProjection student = studentService.findStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    // get all students by a teacher
    @GetMapping("/teachers/{teacherId}/students")
    public ResponseEntity<List<StudentProjection>> findStudentsByTeacher(@PathVariable Long teacherId){

        List<StudentProjection> studentsList= studentService.findStudentsByTeacher(teacherId);

        return ResponseEntity.status(HttpStatus.OK).body(studentsList);
    }
}
