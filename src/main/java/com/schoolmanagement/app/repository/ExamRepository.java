package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Exam;
import com.schoolmanagement.app.repository.projection.ExamListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {

    @Query(value = """
        SELECT
            e.id AS id,
            s.name AS subjectName,
            c.name AS className,
            CONCAT(t.name, ' ', t.surname) AS teacher,
            CAST(e.start_time AS DATE) AS date
        FROM exam e
        LEFT JOIN lesson l ON l.id = e.lesson
        LEFT JOIN subject s ON s.id = l.subject
        LEFT JOIN class_room c ON c.id = l.class_room
        LEFT JOIN teacher t ON t.id = l.teacher
        ORDER BY e.id ASC
        """, nativeQuery = true)
    List<ExamListProjection> getExamList();
}
