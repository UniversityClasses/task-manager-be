package com.example.taskmanager.exceptions.status;

import java.util.Date;
import java.util.Map;

public class StateManagerFieldValidationException extends StateManagerException {

    private Map<String, String> fieldErrors;


    public StateManagerFieldValidationException(Date timestamp, String message, String path, Integer status, Map<String, String> fieldErrors) {
        super(timestamp, message, path, status);
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}