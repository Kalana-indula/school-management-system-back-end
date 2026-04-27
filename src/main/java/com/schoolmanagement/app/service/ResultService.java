package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.ResultProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {

    List<ResultProjection> getResultList();

    List<ResultProjection> getResultsByStudent(Long studentId);
}
