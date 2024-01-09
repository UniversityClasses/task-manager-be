package com.example.taskmanager.tasks;

import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.Optional;

public interface TaskRepository {
    Collection<Task> findAll();

    Task save(Task task);

    Optional<Task> findOne(Example<Task> of);

    void delete(Task task);

    Task findOneByUuid(String uuid);
}
