package com.schoolmanagement.app.repository.projection;

import java.time.LocalDate;

public interface AssignmentListProjection {
    Long getId();

    String getSubjectName();

    String getClassName();

    String getTeacher();

    LocalDate getDueDate();
}
