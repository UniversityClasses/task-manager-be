package com.example.taskmanager.exceptions;

public class CategoryManagerEntityNotFoundException extends RuntimeException {
    public CategoryManagerEntityNotFoundException(String entityName, String uuid) {
        super(String.format("Entity: %s not found with uuid(s)=%s", entityName, uuid));
    }
}
