package com.schoolmanagement.app.service;

import com.schoolmanagement.app.repository.projection.ResultListProjection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {

    List<ResultListProjection> getResultList();
}
