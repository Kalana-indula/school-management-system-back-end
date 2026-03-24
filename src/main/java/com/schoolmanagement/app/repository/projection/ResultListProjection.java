package com.schoolmanagement.app.repository.projection;

import java.time.LocalDate;

public interface ResultListProjection {


    Integer getId();

    Integer getScore();

    String getStudent();

    String getTeacher();

    String getClassName();

    LocalDate getDate();
}
