package com.example.taskmanager.tasks;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TaskRepositoryBean implements TaskRepository {

    private static final List<Task> taskList = new ArrayList<>();

    static {
        taskList.add(new Task("task 1", "task 1 description", "cat 1", "status 1", UUID.randomUUID().toString()));
        taskList.add(new Task("task 2", "task 2 description", "cat 1", "status 2", UUID.randomUUID().toString()));
        taskList.add(new Task("task 3", "task 3 description", "cat 1", "status 3", UUID.randomUUID().toString()));
    }
    @Override
    public Collection<Task> findAll() {
        return taskList;
    }

    @Override
    public Task save(Task task) {
        return task;
    }

    @Override
    public Optional<Task> findOne(Example<Task> of) {
        return Optional.ofNullable(taskList.get(0));
    }

    @Override
    public void delete(Task task) {

    }

    @Override
    public Task findOneByUuid(String uuid) {
        return new Task("Task 1", "description", "category", "status", uuid);
    }
}
