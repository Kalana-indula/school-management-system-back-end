package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.EventListProjection;
import com.schoolmanagement.app.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Repository("/api/v1/events")
@CrossOrigin(origins = "*")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventListProjection>> findEventList(){
        List<EventListProjection> events=eventService.getEventList();
        return ResponseEntity.status(HttpStatus.OK).body(events);
    }
}
