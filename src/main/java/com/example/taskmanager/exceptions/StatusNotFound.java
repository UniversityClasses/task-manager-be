package com.example.taskmanager.exceptions;

import java.util.UUID;

public class StatusNotFound extends TaskManagerEntityNotFoundException {
    public StatusNotFound(String uuid) {
        super("Status", uuid);
    }
}
