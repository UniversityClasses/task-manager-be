package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.status.Status;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryBean implements TaskRepository {

    private static final List<Task> taskList = new ArrayList<>();
    private static final Category category1 = new Category("Category 1","Category 1 Description","559ffa0a-5bb7-4207-a14e-93090623dec7");
    private static final Status status1 = new Status("To Do","559ffa0a-5bb7-4207-a14e-93090623des7");
    private static final Status status2 = new Status("To Do","559ffa0a-5bb7-4207-a14e-93090623des8");
    private static final Status status3 = new Status("To Do","559ffa0a-5bb7-4207-a14e-93090623des9");

    static {
        taskList.add(new Task("task 1", "task 1 description", category1, status1, "559ffa0a-5bb7-4207-a14e-93090623det8"));
        taskList.add(new Task("task 2", "task 2 description", category1, status2, "559ffa0a-5bb7-4207-a14e-93090623det7"));
        taskList.add(new Task("task 3", "task 3 description", category1, status3, "559ffa0a-5bb7-4207-a14e-93090623det9"));
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
        return new Task("Task 1", "description", category1, status1, uuid);
    }
}
