package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.ClassEntity;
import com.schoolmanagement.app.repository.projection.ClassProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassEntityRepository extends JpaRepository<ClassEntity, Long> {

    @Query(value = """
        SELECT
            c.id AS id,
            c.name AS name,
            g.level AS grade,
            c.capacity AS capacity,
            COALESCE(CONCAT(t.name, ' ', t.surname), '') AS supervisor
        FROM class_room c
        LEFT JOIN grade g ON g.id = c.grade
        LEFT JOIN teacher t ON t.id = c.teacher
        ORDER BY c.name ASC
        """, nativeQuery = true)
    List<ClassProjection> getClassList();

    @Query(value = """
        SELECT
            c.id AS id,
            c.name AS name,
            g.level AS grade,
            c.capacity AS capacity,
            COALESCE(CONCAT(t.name, ' ', t.surname), '') AS supervisor
        FROM class_room c
        LEFT JOIN grade g ON g.id = c.grade
        LEFT JOIN teacher t ON t.id = c.teacher
        WHERE t.id = :teacherId
        ORDER BY c.name ASC
        """, nativeQuery = true)
    List<ClassProjection> getClassesByTeacher(Long teacherId);
}
