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
    List<Task> findAllByCategories_UuidIn(List<String> uuids);
    List<Task> findAllByStatusIn(List<String> status);
    List<Task> findAllByCategories_UuidInAndStatusIn(List<String> uuids, List<String> status);
}
