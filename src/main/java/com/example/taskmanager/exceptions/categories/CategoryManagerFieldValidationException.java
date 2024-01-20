package com.example.taskmanager.exceptions.categories;

import java.util.Date;
import java.util.Map;

public class CategoryManagerFieldValidationException extends CategoryManagerException {

    private Map<String, String> fieldErrors;


    public CategoryManagerFieldValidationException(Date timestamp, String message, String path, Integer status, Map<String, String> fieldErrors) {
        super(timestamp, message, path, status);
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}