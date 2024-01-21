package com.example.taskmanager.tasks;

import com.example.taskmanager.categories.Category;
import com.example.taskmanager.categories.CategoryDTO;
import com.example.taskmanager.categories.CategoryMapper;
import com.example.taskmanager.status.State;
import com.example.taskmanager.status.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TaskMapper {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private StateMapper statusMapper;

    public TaskDTO toDTO(Task task) {

            List<CategoryDTO> categories = Optional.ofNullable(task.getCategories())
                    .orElseGet(Arrays::asList)
                    .stream()
                    .map(c -> categoryMapper.toDTO(c))
                    .toList();
            return new TaskDTO(task.getUuid(), task.getName(), task.getDescription(), categories, statusMapper.toDTO(task.getStatus()));
    }

    public Task toModel(TaskDTO dto) {
        List<Category> categories = Optional.ofNullable(dto.getCategories())
                .orElseGet(Arrays::asList)
                .stream()
                .map(c -> categoryMapper.toModel(c))
                .toList();
        return new Task(dto.getName(), dto.getDescription(), categories, statusMapper.toModel(dto.getStatus()), dto.getUuid());
    }
}
