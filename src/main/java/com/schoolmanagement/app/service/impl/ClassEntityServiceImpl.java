package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.ClassEntityRepository;
import com.schoolmanagement.app.repository.projection.ClassProjection;
import com.schoolmanagement.app.service.ClassEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassEntityServiceImpl implements ClassEntityService {

    private final ClassEntityRepository classEntityRepository;

    @Autowired
    public ClassEntityServiceImpl(ClassEntityRepository classEntityRepository) {
        this.classEntityRepository = classEntityRepository;
    }

    @Override
    public List<ClassProjection> getClassList() {
        return classEntityRepository.getClassList();
    }

    @Override
    public List<ClassProjection> getClassesByTeacher(Long teacherId) {

        List<ClassProjection> classes=classEntityRepository.getClassesByTeacher(teacherId);

        if (classes.isEmpty()) {
            throw new ResourceNotFoundException("No classes found for teacher id : "+teacherId);
        }

        return classes;
    }
}
