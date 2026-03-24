package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.SubjectTeacherListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    List<SubjectTeacherListProjection> getSubjectTeacherList();
}
