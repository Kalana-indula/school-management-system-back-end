package com.schoolmanagement.app.service;

import com.schoolmanagement.app.dto.GradeDto;
import com.schoolmanagement.app.entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeService {

    Grade createGrade(GradeDto gradeDto);

    List<Grade> getAllGrades();

}
