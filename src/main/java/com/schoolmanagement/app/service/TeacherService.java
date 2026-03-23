package com.schoolmanagement.app.service;

import com.schoolmanagement.app.entity.Student;
import com.schoolmanagement.app.entity.Teacher;
import com.schoolmanagement.app.repository.projection.TeacherListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<TeacherListProjection> findAllTeachers();

}
