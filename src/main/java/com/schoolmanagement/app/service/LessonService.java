package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.LessonListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {

    List<LessonListProjection> getLessonList();
}
