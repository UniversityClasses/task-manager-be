package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.category.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        String category = task.getCategory();
//        CategoryDTO dto = null;
//        if (category != null ) {
//            dto =  new CategoryDTO(category.getUuid(), category.getName(), category.getDescription());
//        }
        return new TaskDTO(task.getUuid(), task.getName(), task.getDescription(), category, task.getStatus());
    }

    public Task toModel(TaskDTO dto) {
//        CategoryDTO category = dto.getCategory();
//        String categoryModel = null;
//        if (category != null ) {
//            categoryModel = new Category(category.getUuid());
//        }
        return new Task(dto.getName(), dto.getDescription(), dto.getCategory(), dto.getStatus(), dto.getUuid());
    }
}
