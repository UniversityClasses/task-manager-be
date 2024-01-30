package com.example.taskmanager.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> getCategoryByUuid(UUID uuid);

    List<Category> findAllByUuidIn(List<UUID> uuids);

    List<Category> findAll();

    @Query("Select c From Category c where c.name like %?1% or c.description like %?1%")
    List<Category> searchByNameDescrition(String palabra);

//    @Procedure(name = "get_category_by_id")
//    Category getCategoryById(@Param("categoryId") Long categoryId);


}
