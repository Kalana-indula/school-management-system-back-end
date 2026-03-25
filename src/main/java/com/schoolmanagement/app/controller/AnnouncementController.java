package com.schoolmanagement.app.controller;

import com.schoolmanagement.app.repository.projection.AnnouncementListProjection;
import com.schoolmanagement.app.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/announcements")
@CrossOrigin(origins = "*")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementListProjection>>  getAnnouncementList() {
        List<AnnouncementListProjection>  announcementList = announcementService.getAnnouncementList();
        return ResponseEntity.status(HttpStatus.OK).body(announcementList);
    }
}
