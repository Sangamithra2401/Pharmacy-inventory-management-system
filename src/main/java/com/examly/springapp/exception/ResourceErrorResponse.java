package com.examly.springapp.exception;

import java.time.LocalDateTime;

public class ResourceErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    
    public ResourceErrorResponse() {
    }
    public ResourceErrorResponse(int status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    

}