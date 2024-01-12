package com.example.taskmanager.tasks;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TaskRepositoryBean implements TaskRepository {

    private static final List<Task> taskList = new ArrayList<>();

    static {
        taskList.add(new Task("task 1", "task 1 description", "cat 1", "status 1", "559ffa0a-5bb7-4207-a14e-93090623dec8",false));
        taskList.add(new Task("task 2", "task 2 description", "cat 1", "status 2", "559ffa0a-5bb7-4207-a14e-93090623dec7",false));
        taskList.add(new Task("task 3", "task 3 description", "cat 1", "status 3", "559ffa0a-5bb7-4207-a14e-93090623dec9",true));
    }
    @Override
    public Collection<Task> findAll() {
        //return taskList;
        return taskList.stream().filter(task -> !task.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public Task save(Task task) {
        //return task;
        taskList.add(task);
        return task;
    }

    @Override
    public Optional<Task> findOne(Example<Task> of) {
        //return Optional.ofNullable(taskList.get(0));
        return Optional.ofNullable(findOneByUuid(of.getProbe().getUuid()));
    }

    @Override
    public void delete(Task task) {
        task.setDeleted(true);
    }

    @Override
    public Task findOneByUuid(String uuid) {
        //return new Task("Task 1", "description", "category", "status", uuid,false);
        Task searched = null;
        for (Task task : taskList) {
            if (task.getUuid().equals(uuid)) {
                searched = task;
            }
        }
        return searched;
    }
}
