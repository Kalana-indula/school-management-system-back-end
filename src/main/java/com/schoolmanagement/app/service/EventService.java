package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.EventListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    List<EventListProjection> getEventList();
}
