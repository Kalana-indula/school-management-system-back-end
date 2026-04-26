package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Student;
import com.schoolmanagement.app.repository.projection.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = """
        SELECT
            s.id AS id,
            s.name AS name,
            s.surname AS surname,
            s.student_id AS studentId,
            g.level AS grade,
            ce.name AS className,
            s.phone AS phone,
            s.address AS address,
            s.img AS image
        FROM student s
        INNER JOIN grade g
            ON g.id = s.grade
        INNER JOIN class_room ce
            ON ce.id = s.class_room
        ORDER BY s.name
        """, nativeQuery = true)
    List<StudentProjection> getAllStudentsList();

    //fetch a single student by id
    @Query(value = """
        SELECT
            s.id AS id,
            s.name AS name,
            s.surname AS surname,
            s.student_id AS studentId,
            g.level AS grade,
            ce.name AS className,
            s.phone AS phone,
            s.address AS address,
            s.img AS image
        FROM student s
        INNER JOIN grade g
            ON g.id = s.grade
        INNER JOIN class_room ce
            ON ce.id = s.class_room
        WHERE s.id = :id
        """, nativeQuery = true)
    StudentProjection getStudentById(Long id);

    //fetch students by teacher
    @Query(value = """
        SELECT
            s.id AS id,
            s.name AS name,
            s.student_id AS studentId,
            g.level AS grade,
            ce.name AS className,
            s.phone AS phone,
            s.address AS address,
            s.img AS image
        FROM student s
        INNER JOIN grade g
            ON g.id = s.grade
        INNER JOIN class_room ce
            ON ce.id = s.class_room
        INNER JOIN teacher t
            ON t.id = ce.teacher
        WHERE t.id = :teacherId
        ORDER BY s.name
        """, nativeQuery = true)
    List<StudentProjection> getStudentsByTeacher(Long teacherId);


}
