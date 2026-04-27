package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.LessonRepository;
import com.schoolmanagement.app.repository.projection.LessonProjection;
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
    public List<LessonProjection> getLessonList() {
        return lessonRepository.getLessonList();
    }

    @Override
    public List<LessonProjection> getLessonsByTeacher(Long teacherId) {

        List<LessonProjection> lessons=lessonRepository.getLessonsByTeacher(teacherId);

        if(lessons.isEmpty()){
            throw new ResourceNotFoundException("No lessons found for teacher ID : "+teacherId);
        }

        return lessons;
    }

    //get all the lessons taken by student
    @Override
    public List<LessonProjection> getLessonsByStudent(Long studentId) {

        List<LessonProjection> lessons=lessonRepository.getLessonsByStudent(studentId);

        if(lessons.isEmpty()){
            throw new ResourceNotFoundException("No lessons found for student ID : "+studentId);
        }

        return lessons;
    }
}
