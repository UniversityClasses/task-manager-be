package com.example.taskmanager.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface CategoryRepository extends JpaRepository<Category,Long> {

//    Optional<Task> getCategoryByUuid(UUID uuid);

    List<Category> findAllByUuidIn(List<UUID> uuids);

    List<Category> findAllByTasks_UuidIn(List<String> taskIdList);

    Optional<Category> getCategoryByUuid(UUID uuid);

//    @Procedure(name = "get_category_by_id")
//    Category getCategoryById(@Param("categoryId") Long categoryId);
}
