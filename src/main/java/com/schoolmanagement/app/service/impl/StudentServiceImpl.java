package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.StudentRepository;
import com.schoolmanagement.app.repository.projection.StudentProjection;
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
    public List<StudentProjection> findAllStudents() {
        return studentRepository.getAllStudentsList();
    }

    @Override
    public StudentProjection findStudentById(Long studentId) {

        StudentProjection student=studentRepository.getStudentById(studentId);

        if(student == null){
            throw new ResourceNotFoundException("No students found for id : "+studentId);
        }

        return student;
    }

    @Override
    public List<StudentProjection> findStudentsByTeacher(Long teacherId) {

        List<StudentProjection> students=studentRepository.getStudentsByTeacher(teacherId);

        if(students.isEmpty()){
            throw new ResourceNotFoundException("No students found for teacher id : "+teacherId);
        }

        return students;
    }
}
