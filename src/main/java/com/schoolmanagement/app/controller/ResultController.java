package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.ResultListProjection;
import com.schoolmanagement.app.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/results")
@CrossOrigin(origins = "*")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    public ResponseEntity<List<ResultListProjection>> findResults(){

        List<ResultListProjection> results=resultService.getResultList();
        return ResponseEntity.status(HttpStatus.OK).body(results);
    }
}
