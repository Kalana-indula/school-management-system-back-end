package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.dto.create.CreateClassDto;
import com.schoolmanagement.app.entity.ClassEntity;
import com.schoolmanagement.app.entity.Grade;
import com.schoolmanagement.app.entity.Teacher;
import com.schoolmanagement.app.exception.ResourceNotFoundException;
import com.schoolmanagement.app.repository.ClassEntityRepository;
import com.schoolmanagement.app.repository.GradeRepository;
import com.schoolmanagement.app.repository.TeacherRepository;
import com.schoolmanagement.app.repository.projection.ClassProjection;
import com.schoolmanagement.app.service.ClassEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassEntityServiceImpl implements ClassEntityService {

    private final ClassEntityRepository classEntityRepository;
    private final GradeRepository gradeRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public ClassEntityServiceImpl(
            ClassEntityRepository classEntityRepository,
            GradeRepository gradeRepository,
            TeacherRepository teacherRepository
    ) {
        this.classEntityRepository = classEntityRepository;
        this.gradeRepository = gradeRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<ClassProjection> getClassList() {
        return classEntityRepository.getClassList();
    }

    @Override
    public List<ClassProjection> getClassesByTeacher(Long teacherId) {

        List<ClassProjection> classes = classEntityRepository.getClassesByTeacher(teacherId);

        if (classes.isEmpty()) {
            throw new ResourceNotFoundException("No classes found for teacher id : " + teacherId);
        }

        return classes;
    }

    @Override
    public ClassEntity createClass(CreateClassDto createClassDto) {

        Grade existingGrade = gradeRepository.findById(createClassDto.getGradeId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No grades found for entered id : " + createClassDto.getGradeId()
                        )
                );

        Teacher existingTeacher = teacherRepository.findById(createClassDto.getTeacherId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No teachers found for entered id : " + createClassDto.getTeacherId()
                        )
                );

        String classIndex = createClassDto.getClassIndex().toUpperCase();

        //assure classIndex only have a one letter
        if (!classIndex.matches("[A-Z]")) {
            throw new IllegalArgumentException("Class index must be a single letter");
        }

        String className = existingGrade.getLevel() + classIndex;

        //new class object
        ClassEntity classEntity = new ClassEntity();

        classEntity.setName(className);
        classEntity.setCapacity(createClassDto.getCapacity());
        classEntity.setGrade(existingGrade);
        classEntity.setTeacher(existingTeacher);


        return classEntityRepository.save(classEntity);
    }
}
