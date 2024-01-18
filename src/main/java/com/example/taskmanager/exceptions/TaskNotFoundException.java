package com.example.taskmanager.exceptions;

public class TaskNotFoundException extends TaskManagerEntityNotFoundException {
    public TaskNotFoundException(String uuid) {
        super("Task", uuid);
    }
}
