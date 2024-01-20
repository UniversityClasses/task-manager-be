package com.example.taskmanager.exceptions.status;

public class StateManagerEntityNotFoundException extends RuntimeException {
    public StateManagerEntityNotFoundException(String entityName, String uuid) {
        super(String.format("Entity: %s not found with uuid(s)=%s", entityName, uuid));
    }
}