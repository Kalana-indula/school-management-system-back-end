package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Parent;
import com.schoolmanagement.app.repository.projection.ParentListProjection;
import com.schoolmanagement.app.repository.projection.ParentStudentRowProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    @Query(value = """
                SELECT 
                p.id AS id,
                p.name AS name,
                p.phone AS phone,
                p.address AS address,
                p.email AS email,
                s.name AS studentName
                FROM parent p 
                LEFT JOIN student s
                ON s.parent_id=p.id
                ORDER BY p.name,
                s.name
            """, nativeQuery = true)
    List<ParentStudentRowProjection> getParentList();
}
