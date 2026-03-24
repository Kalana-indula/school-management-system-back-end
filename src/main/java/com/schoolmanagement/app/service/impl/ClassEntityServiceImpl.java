package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.ClassEntityRepository;
import com.schoolmanagement.app.repository.projection.ClassListProjection;
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
    public List<ClassListProjection> getClassList() {
        return classEntityRepository.getClassList();
    }
}
