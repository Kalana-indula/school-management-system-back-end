package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.ExamRepository;
import com.schoolmanagement.app.repository.projection.ExamProjection;
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
    public List<ExamProjection> getExamList() {
        return examRepository.getExamList();
    }

    @Override
    public List<ExamProjection> getExamsByTeacher(Long teacherId) {

        List<ExamProjection> examList=examRepository.getExamsByTeacher(teacherId);

        if(examList.isEmpty()){
            throw new ResourceNotFoundException("No exams found for teacher Id "+teacherId);
        }

        return examList;
    }
}
