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
            s.id AS subjectId,
            s.name AS subjectName,
            COALESCE(
                STRING_AGG(DISTINCT CONCAT(t.first_name, ' ', t.last_name), ', ' ORDER BY t.first_name, t.last_name),
                ''
            ) AS teacherList
        FROM subjects s
        LEFT JOIN subject_teacher st ON st.subject_id = s.id
        LEFT JOIN teachers t ON t.id = st.teacher_id
        GROUP BY s.id, s.name
        ORDER BY s.name ASC
        """, nativeQuery = true)
    List<SubjectTeacherListProjection> getAllSubjectList();
}
