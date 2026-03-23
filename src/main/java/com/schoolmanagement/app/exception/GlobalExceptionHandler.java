package com.schoolmanagement.app.exception;

import com.schoolmanagement.app.exception.error.GlobalErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GlobalErrorResponse> handleGenericException(Exception exc) {
        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse();
        globalErrorResponse.setMessage(exc.getMessage());
        globalErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        globalErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(globalErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
