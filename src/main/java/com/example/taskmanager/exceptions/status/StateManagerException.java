package com.example.taskmanager.exceptions.status;

import lombok.Data;

import java.util.Date;
@Data
public class StateManagerException {
    private Date timestamp;
    private String message;
    private String path;

    private Integer status;

    public StateManagerException(Date timestamp, String message, String path, Integer status) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.status = status;
    }
}
