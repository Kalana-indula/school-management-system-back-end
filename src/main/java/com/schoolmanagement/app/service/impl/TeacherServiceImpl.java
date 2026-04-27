package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.TeacherRepository;
import com.schoolmanagement.app.repository.projection.TeacherProjection;
import com.schoolmanagement.app.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {

        this.teacherRepository = teacherRepository;
    }

    //Find all available teachers
    @Override
    public List<TeacherProjection> findAllTeachers() {

        return teacherRepository.getAllTeachersList();
    }

    @Override
    public TeacherProjection findTeacherById(Long id) {

        TeacherProjection teacherDetails=teacherRepository.getTeacherById(id);

        if(teacherDetails == null) {
            throw new ResourceNotFoundException("Teacher not found with id :"+id);
        }

        return teacherDetails;
    }

    @Override
    public List<TeacherProjection> findTeacherByStudent(Long studentId) {

        List<TeacherProjection> teachers=teacherRepository.getTeachersByStudent(studentId);

        if(teachers.isEmpty()) {
            throw new ResourceNotFoundException("Teacher not found for entered student id : "+studentId);
        }

        return teachers;
    }

}
