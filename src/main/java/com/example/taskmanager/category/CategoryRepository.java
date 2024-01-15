package com.example.taskmanager.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//    Optional<Task> getCategoryByUuid(UUID uuid);

    List<Category> findAllByUuidIn(List<UUID> uuids);

//    @Procedure(name = "get_category_by_id")
//    Category getCategoryById(@Param("categoryId") Long categoryId);
}
