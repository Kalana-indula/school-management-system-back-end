package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Lesson;
import com.schoolmanagement.app.repository.projection.LessonListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query(value = """
        SELECT
            l.id AS id,
            s.name AS subjectName,
            c.name AS className,
            CONCAT(t.name, ' ', t.surname) AS teacher
        FROM lesson l
        LEFT JOIN subject s ON s.id = l.subject
        LEFT JOIN class_room c ON c.id = l.class_room
        LEFT JOIN teacher t ON t.id = l.teacher
        ORDER BY l.id ASC
        """, nativeQuery = true)
    List<LessonListProjection> getLessonList();
}
