package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.ResultProjection;
import com.schoolmanagement.app.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/results")
    public ResponseEntity<List<ResultProjection>> findResults(){

        List<ResultProjection> results=resultService.getResultList();
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

    //results obtained by a student
    @GetMapping("/students/{studentId}/results")
    public ResponseEntity<List<ResultProjection>> findResultsByStudent(@PathVariable Long studentId){
        List<ResultProjection> results=resultService.getResultsByStudent(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }

}
