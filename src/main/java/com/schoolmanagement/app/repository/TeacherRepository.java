package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Teacher;
import com.schoolmanagement.app.repository.projection.TeacherProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {


//  Find the teachers details
@Query(value = """
        SELECT
            t.id AS id,
            t.name AS name,
            t.surname AS surname,
            t.teacher_id AS teacherId,
            t.email AS email,
            t.img AS img,
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
        GROUP BY t.id, t.name,t.surname, t.teacher_id, t.email, t.img, t.phone, t.address
        ORDER BY t.name
        """, nativeQuery = true)
    List<TeacherProjection> getAllTeachersList();


    @Query(value = """
            SELECT
                t.id AS id,
                t.name AS name,
                t.surname AS surname,
                t.teacher_id AS teacherId,
                t.email AS email,
                t.blood_type AS bloodType,
                t.birthday AS birthday,
                t.img AS img,
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
            WHERE t.id = :id
            GROUP BY 
                t.id,
                t.name,
                t.surname,
                t.teacher_id,
                t.email,
                t.blood_type,
                t.img,
                t.phone,
                t.address,
                t.birthday,
            """, nativeQuery = true)
    TeacherProjection getTeacherById(Long id);


    // get teachers by student
    @Query(value = """
        SELECT
            t.id AS id,
            t.name AS name,
            t.surname AS surname,
            t.teacher_id AS teacherId,
            t.email AS email,
            t.img AS img,
            COALESCE(
                STRING_AGG(DISTINCT sub.name, ', ' ORDER BY sub.name),
                ''
            ) AS subjects,
            COALESCE(
                STRING_AGG(DISTINCT cr.name, ', ' ORDER BY cr.name),
                ''
            ) AS classes,
            t.phone AS phone,
            t.address AS address
        FROM student st
        INNER JOIN class_room cr
            ON cr.id = st.class_room
        INNER JOIN lesson l
            ON l.class_room = cr.id
        INNER JOIN teacher t
            ON t.id = l.teacher
        LEFT JOIN teacher_subject ts
            ON ts.teacher_id = t.id
        LEFT JOIN subject sub
            ON sub.id = ts.subject_id
        WHERE st.id = :id
        GROUP BY
            t.id,
            t.name,
            t.surname,
            t.teacher_id,
            t.email,
            t.img,
            t.phone,
            t.address
        ORDER BY t.name
        """, nativeQuery = true)
    List<TeacherProjection> getTeachersByStudent(Long id);
}
