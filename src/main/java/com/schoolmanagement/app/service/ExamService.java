package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.ExamProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {

    List<ExamProjection> getExamList();

    List<ExamProjection> getExamsByTeacher(Long teacherId);
}
