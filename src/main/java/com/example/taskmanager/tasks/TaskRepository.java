package com.example.taskmanager.tasks;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> getTaskByUuid(UUID uuid);

    List<Task> findAllByCategoryIn(List<String> category);
    List<Task> findAllByStatusIn(List<String> status);
    List<Task> findAllByCategoryInAndStatusIn(List<String> category, List<String> status);
}
