package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.AnnouncementRepository;
import com.schoolmanagement.app.repository.projection.AnnouncementListProjection;
import com.schoolmanagement.app.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<AnnouncementListProjection> getAnnouncementList() {
        return announcementRepository.getAnnouncementList();
    }
}
