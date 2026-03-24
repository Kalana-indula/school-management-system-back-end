package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Subject;
import com.schoolmanagement.app.repository.projection.SubjectTeacherListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query(value = """
    SELECT
        s.id AS id,
        s.name AS subjectName,
        COALESCE(
            STRING_AGG(
                DISTINCT CONCAT(t.name, ' ', t.surname),
                ', ' ORDER BY CONCAT(t.name, ' ', t.surname)
            ),
            ''
        ) AS teacherList
    FROM subject s
    LEFT JOIN teacher_subject ts ON ts.subject_id = s.id
    LEFT JOIN teacher t ON t.id = ts.teacher_id
    GROUP BY s.id, s.name
    ORDER BY s.name ASC
    """, nativeQuery = true)
    List<SubjectTeacherListProjection> getAllSubjectList();
}
