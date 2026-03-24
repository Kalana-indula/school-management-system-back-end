package com.schoolmanagement.app.service.impl;

import com.schoolmanagement.app.repository.ParentRepository;
import com.schoolmanagement.app.repository.projection.ParentListProjection;
import com.schoolmanagement.app.repository.projection.ParentStudentRowProjection;
import com.schoolmanagement.app.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public List<ParentListProjection> getAllParents() {

        List<ParentStudentRowProjection> parentRows=parentRepository.getParentList();
        Map<Long,ParentListProjection> groupedParents=new LinkedHashMap<>();

        for (ParentStudentRowProjection row : parentRows) {
            ParentListProjection parent = groupedParents.computeIfAbsent(
                    row.getId(),
                    id -> new ParentListProjection(
                            row.getId(),
                            row.getName(),
                            row.getPhone(),
                            row.getAddress(),
                            row.getEmail()
                    )
            );
            parent.addStudent(row.getStudentName());
        }

        return new ArrayList<>(groupedParents.values());
    }
}
