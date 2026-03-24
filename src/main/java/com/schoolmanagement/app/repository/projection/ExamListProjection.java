package com.schoolmanagement.app.repository.projection;

import java.time.LocalDate;

public interface ExamListProjection {

    Long getId();

    String getSubjectName();

    String getClassName();

    String getTeacher();

    LocalDate getDate();
}
