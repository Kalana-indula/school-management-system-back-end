package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.EventRepository;
import com.schoolmanagement.app.repository.projection.EventListProjection;
import com.schoolmanagement.app.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventListProjection> getEventList() {
        return eventRepository.getEventList();
    }
}
