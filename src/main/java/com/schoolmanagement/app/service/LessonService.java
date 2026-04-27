package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.LessonProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {

    List<LessonProjection> getLessonList();

    List<LessonProjection> getLessonsByTeacher(Long teacherId);

    List<LessonProjection> getLessonsByStudent(Long studentId);
}
