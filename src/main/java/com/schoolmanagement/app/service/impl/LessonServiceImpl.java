package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.LessonRepository;
import com.schoolmanagement.app.repository.projection.LessonListProjection;
import com.schoolmanagement.app.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<LessonListProjection> getLessonList() {
        return lessonRepository.getLessonList();
    }
}
