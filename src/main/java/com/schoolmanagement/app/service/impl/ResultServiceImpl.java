package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.ResultRepository;
import com.schoolmanagement.app.repository.projection.ResultProjection;
import com.schoolmanagement.app.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<ResultProjection> getResultList() {
        return resultRepository.getResultList();
    }

    @Override
    public List<ResultProjection> getResultsByStudent(Long studentId) {

        List<ResultProjection> results=resultRepository.getResultsByStudent(studentId);

        if(results.isEmpty()){
            throw new ResourceNotFoundException("No results found for student id " + studentId);
        }

        return results;
    }
}
