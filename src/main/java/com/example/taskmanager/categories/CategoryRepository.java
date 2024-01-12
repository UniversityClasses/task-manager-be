package com.example.taskmanager.categories;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface CategoryRepository {
    Collection<Category> findAll();

    Category save(Category category);

    Category getByUUID(String uuid);

    Category edit(Category categorySearched, CategoryDTO dto);

    Category delete(Category categorySearched);
}
