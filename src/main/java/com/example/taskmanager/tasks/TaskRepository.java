package com.example.taskmanager.tasks;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class TaskRepository {
    public Collection<Task> findAll() {
        return Collections.emptyList();
    }
}
