package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.ParentRepository;
import com.schoolmanagement.app.repository.projection.ParentListProjection;
import com.schoolmanagement.app.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<ParentListProjection> getAllParentsList() {
       return parentRepository.getAllParentsList();
    }
}
