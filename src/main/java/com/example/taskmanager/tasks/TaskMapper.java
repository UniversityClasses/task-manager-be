package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        CategoryDTO categoryDTO= new CategoryDTO(task.getCategory().getUuid(),task.getCategory().getName(),task.getCategory().getDescription());
        StatusDTO statusDTO = new StatusDTO(task.getStatus().getUuid(),task.getStatus().getName());

        return new TaskDTO(task.getUuid(), task.getName(), task.getDescription(), categoryDTO,statusDTO);
    }

    public Task toModel(TaskDTO dto) {
        Category category = new Category(dto.getName(),dto.getDescription(),dto.getUuid());
        Status status = new Status(dto.getName(), dto.getUuid());
        return new Task(dto.getName(), dto.getDescription(), category,status,dto.getUuid());
    }
}
