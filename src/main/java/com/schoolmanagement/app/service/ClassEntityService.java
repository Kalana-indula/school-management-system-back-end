package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.ClassListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassEntityService {

    List<ClassListProjection>  getClassList();
}
