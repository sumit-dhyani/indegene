package com.assignment.Indegene.model;

import java.time.LocalDateTime;

public class ResponseMsg {
    private int errorCode;
    private LocalDateTime timeStamp;
    private String message;
    private String details;

    public ResponseMsg() {
    }
    public int getErrorCode() {
        return errorCode;
    }

    public ResponseMsg(int errorCode,LocalDateTime timeStamp, String message, String details) {
        this.errorCode=errorCode;
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
