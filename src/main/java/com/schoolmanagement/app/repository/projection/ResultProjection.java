package com.schoolmanagement.app.repository.projection;

import java.time.LocalDate;

public interface ResultProjection {


    Integer getId();

    Integer getScore();

    String getStudent();

    String getTeacher();

    String getClassName();

    String getSubjectName();

    LocalDate getDate();
}
