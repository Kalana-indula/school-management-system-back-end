package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Assignment;
import com.schoolmanagement.app.repository.projection.AssignmentListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment,Long> {
    @Query(value = """
        SELECT
            a.id AS id,
            s.name AS subjectName,
            c.name AS className,
            CONCAT(t.name, ' ', t.surname) AS teacher,
            CAST(a.due_date AS DATE) AS dueDate
        FROM assignment a
        LEFT JOIN lesson l ON l.id = a.lesson
        LEFT JOIN subject s ON s.id = l.subject
        LEFT JOIN class_room c ON c.id = l.class_room
        LEFT JOIN teacher t ON t.id = l.teacher
        ORDER BY a.id ASC
        """, nativeQuery = true)
    List<AssignmentListProjection> getAssignmentList();
}
