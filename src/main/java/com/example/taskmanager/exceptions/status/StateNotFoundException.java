package com.example.taskmanager.exceptions.status;

import com.example.taskmanager.exceptions.tasks.TaskManagerEntityNotFoundException;

public class StateNotFoundException extends TaskManagerEntityNotFoundException {
    public StateNotFoundException(String uuid) {
        super("Status", uuid);
    }
}
