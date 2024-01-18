package com.example.taskmanager.exceptions;

public class StateNotFoundException extends TaskManagerEntityNotFoundException {
    public StateNotFoundException(String uuid) {
        super("Status", uuid);
    }
}
