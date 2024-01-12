package com.example.taskmanager.tasks;

import com.example.taskmanager.categories.Category;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.status.State;
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
        Task task = optionalTask.orElseThrow(() -> new TaskNotFoundException("task Not Found with UUID: " + taskDTO.getUuid()));

        //Task task = optionalTask.get();
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setState(new State(taskDTO.getState()));
        task.setCategory(new Category(taskDTO.getCategory()));
        task.setDeleted(taskDTO.isDeleted());
        //taskRepository.save(task);
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO getOne(String uuid) {
        Task task = getTask(uuid);
        
        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.
        if (task == null){
            throw new TaskNotFoundException("task Not Found with UUID: " + uuid);
        }

        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO delete(String uuid) {
        Task example1 = new Task(uuid);
        Optional<Task> optionalTask = taskRepository.findOne(Example.of(example1));

        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.
        Task task = optionalTask.orElseThrow(() -> new TaskNotFoundException("task Not Found with UUID: " + uuid));

        //Task task = optionalTask.get();
        taskRepository.delete(task);

        return mapper.toDTO(task);
    }


    private Task getTask(String uuid) {
        Task task = taskRepository.findOneByUuid(uuid);
        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.
        if (task == null){
            throw new TaskNotFoundException("task Not Found with UUID: " + uuid);
        }
        return task;
    }
}
