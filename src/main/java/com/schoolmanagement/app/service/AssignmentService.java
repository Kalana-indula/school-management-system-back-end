package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.AssignmentProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentService {

    List<AssignmentProjection>  getAssignmentList();

    List<AssignmentProjection> getAssignmentsByTeacher(Long teacherId);
}
