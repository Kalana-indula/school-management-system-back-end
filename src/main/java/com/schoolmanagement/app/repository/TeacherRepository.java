package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Teacher;
import com.schoolmanagement.app.repository.projection.TeacherListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


//  Find the teachers details
    @Query(value = """
            SELECT
                t.name AS name,
                t.teacher_id AS teacherId,
                COALESCE(
                    STRING_AGG(DISTINCT s.name, ', ' ORDER BY s.name),
                    ''
                ) AS subjects,
                COALESCE(
                    STRING_AGG(DISTINCT cr.name, ', ' ORDER BY cr.name),
                    ''
                ) AS classes,
                t.phone AS phone,
                t.address AS address
            FROM teacher t
            LEFT JOIN teacher_subject ts
                ON ts.teacher_id = t.id
            LEFT JOIN subject s
                ON s.id = ts.subject_id
            LEFT JOIN class_room cr
                ON cr.teacher = t.id
            GROUP BY t.id, t.name, t.teacher_id, t.phone, t.address
            ORDER BY t.name
            """, nativeQuery = true)
    List<TeacherListProjection> getAllTeachersList();
}
