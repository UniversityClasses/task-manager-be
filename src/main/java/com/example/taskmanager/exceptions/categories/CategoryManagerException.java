package com.example.taskmanager.exceptions.categories;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryManagerException {
    private Date timestamp;
    private String message;
    private String path;

    private Integer status;

    public CategoryManagerException(Date timestamp, String message, String path, Integer status) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.status = status;
    }
}
