package com.schoolmanagement.app.service;

import com.schoolmanagement.app.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAllStudents();
}
