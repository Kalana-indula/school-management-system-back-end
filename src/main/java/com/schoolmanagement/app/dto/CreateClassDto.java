package com.schoolmanagement.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateClassDto {

    private String classIndex;
    private Integer capacity;
    private Long gradeId;
    private Long teacherId;
}
