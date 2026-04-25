package com.schoolmanagement.app.repository.projection;

import java.time.LocalDate;

public interface ExamProjection {

    Long getId();

    String getSubjectName();

    String getClassName();

    String getTeacher();

    LocalDate getDate();
}
