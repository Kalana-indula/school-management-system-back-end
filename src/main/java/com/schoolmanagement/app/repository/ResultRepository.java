package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Result;
import com.schoolmanagement.app.repository.projection.ResultListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {

    @Query(value = """
        SELECT
            r.id AS id,
            r.score AS score,
            CONCAT(s.name, ' ', s.surname) AS student,
            CONCAT(t.name, ' ', t.surname) AS teacher,
            c.name AS className,
            CAST(a.due_date AS DATE) AS date
        FROM result r
        LEFT JOIN student s ON s.id = r.student
        LEFT JOIN assignment a ON a.id = r.assignment
        LEFT JOIN lesson l ON l.id = a.lesson
        LEFT JOIN class_room c ON c.id = l.class_room
        LEFT JOIN teacher t ON t.id = l.teacher
        ORDER BY r.id ASC
        """, nativeQuery = true)
    List<ResultListProjection> getResultList();
}
