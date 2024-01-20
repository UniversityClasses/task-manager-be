package com.example.taskmanager.categories;

import com.example.taskmanager.exceptions.categories.CategoryNotFoundException;
import com.example.taskmanager.exceptions.tasks.TaskNotFoundException;
import com.example.taskmanager.tasks.TaskDTO;
import com.example.taskmanager.tasks.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import com.example.taskmanager.tasks.Task;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<CategoryDTO> getAll(List<String> taskIdList) {
        List<Category> categories =
                (!CollectionUtils.isEmpty(taskIdList))
                ? categoryRepository.findAllByTasks_UuidIn(taskIdList):
                categoryRepository.findAll();
        return  categories
                .stream()
                .map(category -> mapper.toDTO(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        List<Task> tasks = Collections.emptyList();
        Set<TaskDTO> taskDTOS = dto.getTasks();
        if(!CollectionUtils.isEmpty(taskDTOS)){
            tasks = taskRepository.findAllByUuidIn(taskDTOS.stream().map(TaskDTO::getUuid).toList());
            if(CollectionUtils.isEmpty(tasks)){
               throw new TaskNotFoundException(taskDTOS.stream().map(TaskDTO::getUuid).toList().toString());
            }
        }
        Category category = mapper.toModel(dto);
        category.setTasks(new HashSet<>(tasks));
        Category saveCategory = categoryRepository.save(category);
        return mapper.toDTO(saveCategory);
    }

    @Override
    public CategoryDTO getOne(UUID uuid) {
        Category category = new Category(uuid);
        Optional<Category> categorySearched = categoryRepository.findOne(Example.of(category));
        if(categorySearched.isEmpty()){
            throw new CategoryNotFoundException(uuid.toString());
        }
        return mapper.toDTO(categorySearched.get());
    }

    @Override
    public CategoryDTO edit(CategoryDTO dto) {
        Optional<Category> categoryEdit = categoryRepository.getCategoryByUuid(dto.getUuid());
        if(categoryEdit.isEmpty()){
            throw new CategoryNotFoundException(dto.getUuid().toString());
        }
        List<Task> tasks;
        Set<TaskDTO> taskDTOS = dto.getTasks();
        if(!CollectionUtils.isEmpty(taskDTOS)){
            List<UUID> taskUuids = taskDTOS.stream().map(TaskDTO::getUuid).toList();
            tasks = taskRepository.findAllByUuidIn(taskUuids);
            List<UUID> missingIds = taskUuids.stream()
                    .filter(id1 -> tasks.stream().noneMatch(id2->id2.getUuid().equals(id1)))
                    .toList();

            if(!CollectionUtils.isEmpty(missingIds)){
                throw new TaskNotFoundException(missingIds.stream().map(UUID::toString).collect(Collectors.joining(", ")));
            }
        }
        else{
           tasks = Collections.emptyList();
        }
      Category category =  categoryEdit.get();
      category.setName(dto.getName());
      category.setDescription(dto.getDescription());
      category.setTasks(new HashSet<>(tasks));
      categoryRepository.save(category);
      return mapper.toDTO(category);
    }

    @Override
    public CategoryDTO delete(UUID uuid) {
        Optional<Category> categorySearched = categoryRepository.getCategoryByUuid(uuid);
        if(categorySearched.isEmpty()){
            throw new CategoryNotFoundException(uuid.toString());
        }
        Category category = categorySearched.get();
        CategoryDTO categoryDTO = mapper.toDTO(category);
        categoryRepository.delete(category);
        return categoryDTO;
    }
}
