package com.example.taskmanager.tasks;

import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        return new TaskDTO(task.getUuid(), task.getName(), task.getDescription(), task.getCategory(), task.getEndedDate(), task.getStatus());
    }

    public Task toModel(TaskDTO dto) {
        return new Task(dto.getName(), dto.getDescription(), dto.getCategory(), dto.getStatus(), dto.getUuid());
    }
}
