package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.AssignmentRepository;
import com.schoolmanagement.app.repository.projection.AssignmentProjection;
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
    public List<AssignmentProjection> getAssignmentList() {
        return assignmentRepository.getAssignmentList();
    }

    @Override
    public List<AssignmentProjection> getAssignmentsByTeacher(Long teacherId) {

        List<AssignmentProjection> assignmentsList=assignmentRepository.getAssignmentsByTeacher(teacherId);

        if(assignmentsList.isEmpty()){
            throw new ResourceNotFoundException("No assignments found for the teacher ID : "+teacherId);
        }
        return assignmentsList;
    }
}
