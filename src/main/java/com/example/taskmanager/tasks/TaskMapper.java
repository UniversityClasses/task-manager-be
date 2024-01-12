package com.example.taskmanager.tasks;

import com.example.taskmanager.categories.Category;
import com.example.taskmanager.status.State;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getUuid(), task.getName(), task.getDescription(), task.getCategory().getName(), task.getState().getName(), task.isDeleted());
    }

    public Task toModel(TaskDTO dto) {
        return new Task(dto.getName(), dto.getDescription(), new Category(dto.getCategory()), new State(dto.getState()), dto.getUuid(),dto.isDeleted());
    }
}
