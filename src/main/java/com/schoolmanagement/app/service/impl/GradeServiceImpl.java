package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.dto.create.GradeDto;
import com.schoolmanagement.app.entity.Grade;
import com.schoolmanagement.app.repository.GradeRepository;
import com.schoolmanagement.app.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade createGrade(GradeDto gradeDto) {

        Grade grade = new Grade();
        grade.setLevel(gradeDto.getLevel());

        Grade createdGrade = gradeRepository.save(grade);

        return createdGrade;
    }

    @Override
    public List<Grade> getAllGrades() {

        List<Grade> grades = gradeRepository.findAll();

        return grades;
    }
}
