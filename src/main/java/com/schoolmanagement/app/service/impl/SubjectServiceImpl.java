package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.SubjectRepository;
import com.schoolmanagement.app.repository.projection.SubjectTeacherListProjection;
import com.schoolmanagement.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectTeacherListProjection> getSubjectTeacherList() {
        return subjectRepository.getAllSubjectList();
    }
}
