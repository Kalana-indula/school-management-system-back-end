package com.schoolmanagement.app.repository.projection;

import java.time.LocalDateTime;

public interface StudentProjection {

    Long getId();

    String getName();

    String getSurname();

    String getStudentId();

    Integer getGrade();

    String getClassName();

    String getImage();

    String getPhone();

    String getAddress();

    LocalDateTime getBirthday();

    String getBloodType();

    String getEmail();
}
