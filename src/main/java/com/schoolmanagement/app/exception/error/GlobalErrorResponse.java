package com.schoolmanagement.app.exception.error;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GlobalErrorResponse {

    private Integer status;
    private String message;
    private Long timeStamp;
}
