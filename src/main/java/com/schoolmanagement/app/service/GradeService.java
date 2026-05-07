package com.schoolmanagement.app.service;

import com.schoolmanagement.app.dto.GradeDto;
import com.schoolmanagement.app.entity.Grade;
import org.springframework.stereotype.Service;

@Service
public interface GradeService {

    Grade createGrade(GradeDto gradeDto);
}
