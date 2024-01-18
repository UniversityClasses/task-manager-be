package com.example.taskmanager.exceptions;

import java.util.Date;
import java.util.Map;

public class TaskManagerFieldValidationException extends TaskManagerException {

    private Map<String, String> fieldErrors;


    public TaskManagerFieldValidationException(Date timestamp, String message, String path, Integer status, Map<String, String> fieldErrors) {
        super(timestamp, message, path, status);
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}
