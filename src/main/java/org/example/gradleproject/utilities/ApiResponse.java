package org.example.gradleproject.utilities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.*;

@Getter
@Setter
public class ApiResponse<T> {

    private T data;
    private String message;
    private boolean success;
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd hh:mm:ss")
    private LocalDateTime timeStamp;

    public ApiResponse() {
        timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data, String message, boolean success) {
        this();
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public ApiResponse(HttpStatus status, String message, boolean success) {
        this();
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, message, true);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(null, message, false);
    }
}

