package com.example.taskmanager.category;

import org.springframework.data.domain.Example;

import java.util.Collection;
import java.util.Optional;

public interface CategoryRepository {
    Collection<Category> findAll();

    Category save(Category category);

    Optional<Category> findOne(Example<Category> of);

    void delete(Category category);

    Category findOneByUuid(String uuid);
}
