package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.entity.Student;
import com.schoolmanagement.app.repository.StudentRepository;
import com.schoolmanagement.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
