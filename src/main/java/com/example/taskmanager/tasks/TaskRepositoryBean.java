package com.example.taskmanager.tasks;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Component
public class TaskRepositoryBean implements TaskRepository {
    @Override
    public Collection<Task> findAll() {
        return Collections.singleton(new Task("Task 1", "description", "category", "status", "1234567"));
    }

    @Override
    public Task save(Task task) {

        return task;
    }

    @Override
    public Optional<Task> findOne(Example<Task> of) {
        return Optional.empty();
    }
}
