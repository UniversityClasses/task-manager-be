package com.example.taskmanager.exceptions.tasks;

public class TaskNotFoundException extends TaskManagerEntityNotFoundException {
    public TaskNotFoundException(String uuid) {
        super("Task", uuid);
    }
}
