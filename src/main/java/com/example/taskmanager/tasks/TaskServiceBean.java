package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.category.CategoryRepository;
import com.example.taskmanager.exceptions.CategoryNotFoundException;
import com.example.taskmanager.exceptions.StatusNotFound;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.status.Status;
import com.example.taskmanager.status.StatusRepository;
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
    @Autowired
    private StatusRepository statusRepository;

    public List<TaskDTO> getAll(List<String> categoryIdList, List<String> statusIdList) {

        List<Task> tasks =
                (!CollectionUtils.isEmpty(categoryIdList) && !CollectionUtils.isEmpty(statusIdList))
                ? taskRepository.findAllByCategories_UuidInAndStatus_UuidIn(categoryIdList, statusIdList) :
                !CollectionUtils.isEmpty(categoryIdList) ? taskRepository.findAllByCategories_UuidIn(categoryIdList) :
                !CollectionUtils.isEmpty(statusIdList) ? taskRepository.findAllByStatus_UuidIn(statusIdList) :
                taskRepository.findAll();

        return tasks
                .stream()
                .map(task -> mapper.toDTO(task))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO create(TaskDTO dto) {
        List<Category> categories = Collections.emptyList();
        Status status = null;
        if (!CollectionUtils.isEmpty(dto.getCategories())) {
            categories = categoryRepository.findAllByUuidIn(dto.getCategories().stream().map(CategoryDTO::getUuid).toList());
            // TODO: ADD EXCEPTION WHEN CATEGORY DO NOT EXIST.
        }

        if (dto.getStatus() != null && dto.getStatus().getUuid() != null) {

            Optional<Status> statusByUuid = statusRepository.getStatusByUuid(dto.getStatus().getUuid());
            // TODO: ADD EXCEPTION WHEN STATUS DO NOT EXIST.
            if (statusByUuid.isPresent()) {
                status = statusByUuid.get();
            }
        }

        Task task = mapper.toModel(dto);
        task.setCategories(categories);
        task.setStatus(status);
        Task savedTask = taskRepository.save(task);
        return mapper.toDTO(savedTask);
    }

    @Override
    public TaskDTO edit(TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.getTaskByUuid(taskDTO.getUuid());

        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException(taskDTO.getUuid().toString());
        }


        List<Category> categories;
        Status status = null;
        if (!CollectionUtils.isEmpty(taskDTO.getCategories())) {
            List<UUID> categoriesUuids = taskDTO.getCategories().stream().map(CategoryDTO::getUuid).toList();
            categories = categoryRepository.findAllByUuidIn(categoriesUuids);
            List<UUID> missingIds = categoriesUuids.stream()
                    .filter(id1 -> categories.stream().noneMatch(obj2 -> obj2.getUuid().equals(id1)))
                    .toList();


            if (!CollectionUtils.isEmpty(missingIds)) {
                throw new CategoryNotFoundException(missingIds.stream().map(UUID::toString).collect(Collectors.joining(", ")));
            }
        } else {
            categories = Collections.emptyList();
        }

        if (taskDTO.getStatus() != null && taskDTO.getStatus().getUuid() != null) {
            Optional<Status> statusByUuid = statusRepository.getStatusByUuid(taskDTO.getStatus().getUuid());
            if (statusByUuid.isPresent()) {
                status = statusByUuid.get();
            } else {
                throw new StatusNotFound(taskDTO.getStatus().getUuid().toString());
            }
        }

        Task task = optionalTask.get();
        task.setDescription(taskDTO.getDescription());
        task.setName(taskDTO.getName());
        task.setStatus(status);
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
