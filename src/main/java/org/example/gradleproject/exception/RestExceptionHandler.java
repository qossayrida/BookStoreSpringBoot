package org.example.gradleproject.exception;


import org.example.gradleproject.utilities.ApiResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ApiResponse<Object> handleSqlIntegrityException(HttpServletRequest req, SQLIntegrityConstraintViolationException ex){
        String error = "Unable to submit post: " + ex.getMessage();
        return new ApiResponse<>(HttpStatus.BAD_REQUEST,error,false);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ApiResponse<Object> handleNoSuchElementException(HttpServletRequest req,NoSuchElementException ex){
        String error = "The row for book is not existent: " + req.getRequestURI();
        return new ApiResponse<>(HttpStatus.NOT_FOUND,error,false);
    }


}
