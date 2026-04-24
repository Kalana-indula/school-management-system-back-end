package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.StudentProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<StudentProjection> findAllStudents();

    List<StudentProjection> findStudentsByTeacher(Long teacherId);
}
