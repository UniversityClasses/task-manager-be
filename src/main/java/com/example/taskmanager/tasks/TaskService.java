package com.example.taskmanager.tasks;

import com.example.taskmanager.dtos.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskService {
    @Autowired
    private TaskRepository tasksRepository;

    @Autowired
    private TaskMapper mapper;

    public List<TaskDTO> getAll() {
        return tasksRepository
                .findAll()
                .stream()
                .map(task -> mapper.toDTO(task))
                .collect(Collectors.toList());
    }
}
