package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.ExamListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {

    List<ExamListProjection> getExamList();
}
