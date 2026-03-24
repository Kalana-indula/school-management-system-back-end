package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.ExamRepository;
import com.schoolmanagement.app.repository.projection.ExamListProjection;
import com.schoolmanagement.app.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public List<ExamListProjection> getExamList() {
        return examRepository.getExamList();
    }
}
