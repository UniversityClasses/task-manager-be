package com.example.taskmanager.category;

import com.example.taskmanager.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Task> getCategoryByUuid(UUID uuid);
}
