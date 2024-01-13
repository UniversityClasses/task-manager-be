package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.status.Status;
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

        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.

        Task task = optionalTask.get();
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        Category category = new Category(taskDTO.getCategory().getName(),taskDTO.getCategory().getDescription(),taskDTO.getCategory().getUuid());
        Status status = new Status(taskDTO.getStatus().getName(),taskDTO.getStatus().getUuid());
        task.setStatus(status);
        task.setCategory(category);

        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO getOne(String uuid) {
        Task task = getTask(uuid);
        
        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.


        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO delete(String uuid) {
        Task example1 = new Task(uuid);
        Optional<Task> optionalTask = taskRepository.findOne(Example.of(example1));

        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.

        Task task = optionalTask.get();
        taskRepository.delete(task);

        return mapper.toDTO(task);
    }


    private Task getTask(String uuid) {
        Task task = taskRepository.findOneByUuid(uuid);
        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.

        return task;
    }
}
