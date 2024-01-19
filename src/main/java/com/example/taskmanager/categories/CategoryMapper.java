package com.example.taskmanager.categories;

import com.example.taskmanager.tasks.Task;
import com.example.taskmanager.tasks.TaskDTO;
import com.example.taskmanager.tasks.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        Set<Task> tasks = category.getTasks();
        return new CategoryDTO(
                category.getUuid(),
                category.getName(),
                category.getDescription(),
                extractTasks(tasks));
    }

    public Category toModel(CategoryDTO dto) {
        return new Category(dto.getUuid(), dto.getName(), dto.getDescription(),null);
    }

    //create this function to avoid an infinite cycle between task and category
    private Set<TaskDTO> extractTasks(Set<Task> tasks) {
        Set<TaskDTO> taskDTOs = new HashSet<>();
        for (Task task : tasks) {
            taskDTOs.add(new TaskDTO(task.getUuid(), task.getName(), task.getDescription()));
        }
        return taskDTOs;
    }
}
