package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Announcement;
import com.schoolmanagement.app.repository.projection.AnnouncementListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    @Query(value = """
        SELECT
            a.id AS id,
            a.title AS title,
            c.name AS className,
            a.date AS date
        FROM announcement a
        LEFT JOIN class_room c ON c.id = a.class_room
        ORDER BY a.id ASC
        """, nativeQuery = true)
    List<AnnouncementListProjection> getAnnouncementList();

}
