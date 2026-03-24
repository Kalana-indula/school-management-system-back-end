package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.ResultRepository;
import com.schoolmanagement.app.repository.projection.ResultListProjection;
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
    public List<ResultListProjection> getResultList() {
        return resultRepository.getResultList();
    }
}
