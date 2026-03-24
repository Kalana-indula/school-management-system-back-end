package com.schoolmanagement.app.repository.projection;

import java.time.LocalDate;
import java.time.LocalTime;

public interface EventListProjection {

    Integer getId();

    String getTitle();

    String getClassName();

    LocalDate getDate();

    LocalTime getStartTime();

    LocalTime getEndTime();
}
