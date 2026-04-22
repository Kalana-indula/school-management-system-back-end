package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.ClassProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassEntityService {

    List<ClassProjection>  getClassList();

    List<ClassProjection> getClassesByTeacher(Long teacherId);
}
