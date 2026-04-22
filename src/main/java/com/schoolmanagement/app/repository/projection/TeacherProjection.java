package com.schoolmanagement.app.repository.projection;

import java.time.LocalDateTime;
import java.util.Date;

public interface TeacherProjection {

    Long getId();

    String getName();

    String getSurname();

    String getTeacherId();

    String getEmail();

    String getBloodType();

    LocalDateTime getBirthday();

    String getImg();

    String getSubjects();

    String getClasses();

    String getPhone();

    String getAddress();
}
