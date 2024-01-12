package com.example.taskmanager.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskServiceBean implements TaskService {

    @Autowired
    private TaskMapper mapper;

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAll() {
        return taskRepository
                .findAll()
                .stream()
                .map(task -> mapper.toDTO(task))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO create(TaskDTO dto) {
        Task task = mapper.toModel(dto);
        Task savedTask = taskRepository.save(task);
        return mapper.toDTO(savedTask);
    }

    @Override
    public TaskDTO edit(TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.getTaskByUuid(taskDTO.getUuid());

        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.

        Task task = optionalTask.get();
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setStatus(taskDTO.getStatus());
        task.setCategory(taskDTO.getCategory());

        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO getOne(String uuid) {
        Optional<Task> task = taskRepository.getTaskByUuid(uuid);
        
        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.


        return mapper.toDTO(task.get());
    }

    @Override
    public TaskDTO delete(String uuid) {
        Optional<Task> optionalTask = taskRepository.getTaskByUuid(uuid);

        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.

        Task task = optionalTask.get();
        taskRepository.delete(task);

        return mapper.toDTO(task);
    }
}
