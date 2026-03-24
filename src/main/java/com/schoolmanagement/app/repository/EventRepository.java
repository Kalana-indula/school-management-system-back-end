package com.schoolmanagement.app.repository;

import com.schoolmanagement.app.entity.Event;
import com.schoolmanagement.app.repository.projection.EventListProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    @Query(value = """
        SELECT
            e.id AS id,
            e.title AS title,
            c.name AS className,
            CAST(e.start_time AS DATE) AS date,
            CAST(e.start_time AS TIME) AS startTime,
            CAST(e.end_time AS TIME) AS endTime
        FROM event e
        LEFT JOIN class_room c ON c.id = e.class_room
        ORDER BY e.id ASC
        """, nativeQuery = true)
    List<EventListProjection> getEventList();
}
