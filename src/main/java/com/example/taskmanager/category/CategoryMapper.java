package com.example.taskmanager.category;

import com.example.taskmanager.tasks.Task;
import com.example.taskmanager.tasks.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        return new CategoryDTO(category.getUuid(), category.getName(), category.getDescription());
    }

    public Category toModel(CategoryDTO dto) {
        return new Category(dto.getUuid(), dto.getName(), dto.getDescription());
    }
}
