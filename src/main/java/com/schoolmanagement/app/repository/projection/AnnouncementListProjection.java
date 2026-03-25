package com.schoolmanagement.app.repository.projection;

import java.time.LocalDateTime;

public interface AnnouncementListProjection {

    Long getId();

    String getTitle();

    String getClassName();

    LocalDateTime getDate();
}
