package com.example.taskmanager.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        Task example1 = new Task(taskDTO.getUuid());
        Optional<Task> optionalTask = taskRepository.findOne(Example.of(example1));

        Task task = optionalTask.get();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getName());
        task.setCategory(taskDTO.getCategory());
        task.setStatus(taskDTO.getStatus());

        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO getOne(String taskId) {
        return null;
    }

    @Override
    public TaskDTO delete(String taskId) {
        return null;
    }
}
