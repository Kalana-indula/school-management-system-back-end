package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.AnnouncementListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnouncementService {

    List<AnnouncementListProjection> getAnnouncementList();
}
