package com.example.taskmanager.exceptions;

public class StatusManagerEntityNotFoundException extends RuntimeException {
    public StatusManagerEntityNotFoundException(String entityName, String uuid) {
        super(String.format("Entity: %s not found with uuid(s)=%s", entityName, uuid));
    }
}
