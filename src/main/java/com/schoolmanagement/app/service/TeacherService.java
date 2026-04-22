package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.TeacherProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<TeacherProjection> findAllTeachers();

    TeacherProjection findTeacherById(Long id);

}
