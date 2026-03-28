package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Parent;
import com.schoolmanagement.app.repository.projection.ParentListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    @Query(value = """
        SELECT
            p.id AS id,
            COALESCE(
                STRING_AGG(
                    DISTINCT CONCAT(s.name, ' ', s.surname),
                    ', ' ORDER BY CONCAT(s.name, ' ', s.surname)
                ),
                ''
            ) AS studentNames,
            p.phone AS phone,
            p.email AS email,
            p.address AS address
        FROM parent p
        LEFT JOIN student s ON s.parent_id = p.id
        GROUP BY p.id, p.phone, p.email, p.address
        ORDER BY p.name ASC, p.surname ASC
        """, nativeQuery = true)
    List<ParentListProjection> getAllParentsList();

}
