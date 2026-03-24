package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.AssignmentRepository;
import com.schoolmanagement.app.repository.projection.AssignmentListProjection;
import com.schoolmanagement.app.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public List<AssignmentListProjection> getAssignmentList() {
        return assignmentRepository.getAssignmentList();
    }
}
