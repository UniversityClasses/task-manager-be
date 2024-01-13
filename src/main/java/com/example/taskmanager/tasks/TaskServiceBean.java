package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.category.CategoryMapper;
import com.example.taskmanager.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TaskServiceBean implements TaskService {

    @Autowired
    private TaskMapper mapper;


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<TaskDTO> getAll(List<String> categoryIdList, List<String> statusIdList) {

        List<Task> tasks =
//                (!CollectionUtils.isEmpty(categoryIdList) && !CollectionUtils.isEmpty(statusIdList))
//                ? taskRepository.findAllByCategoryInAndStatusIn(categoryIdList, statusIdList) :
//                !CollectionUtils.isEmpty(categoryIdList) ? taskRepository.findAllByCategoryIn(categoryIdList) :
//                !CollectionUtils.isEmpty(statusIdList) ? taskRepository.findAllByStatusIn(statusIdList) :
                taskRepository.findAll();

        return tasks
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
        List<Category> categories = Collections.emptyList();
        if (!CollectionUtils.isEmpty(taskDTO.getCategories())) {
            categories = categoryRepository.findAllByUuidIn(taskDTO.getCategories().stream().map(CategoryDTO::getUuid).toList());
            // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.
        }

        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.

        Task task = optionalTask.get();
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setStatus(taskDTO.getStatus());
        task.setCategories(categories);

        taskRepository.save(task);
        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO getOne(UUID uuid) {
        Task task = new Task(uuid);
        Optional<Task> task1 = taskRepository.findOne(Example.of(task));

//        Optional<Task> task = taskRepository.getTaskByUuid(uuid);
        
        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.


        return mapper.toDTO(task1.get());
    }

    @Override
    public TaskDTO delete(UUID uuid) {
        Optional<Task> optionalTask = taskRepository.getTaskByUuid(uuid);

        // TODO: ADD EXCEPTION WHEN TASK DO NOT EXIST.

        Task task = optionalTask.get();
        taskRepository.delete(task);

        return mapper.toDTO(task);
    }
}
