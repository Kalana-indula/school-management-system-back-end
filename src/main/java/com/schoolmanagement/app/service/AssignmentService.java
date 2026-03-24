package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.AssignmentListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssignmentService {

    List<AssignmentListProjection>  getAssignmentList();
}
