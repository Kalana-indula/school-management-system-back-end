package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.ParentListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParentService {

    List<ParentListProjection> getAllParents();
}
