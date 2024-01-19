package com.example.taskmanager.exceptions;

public class StatusNotFoundException extends StatusManagerEntityNotFoundException {
    public StatusNotFoundException(String uuid) {
        super("Status", uuid);
    }
}
