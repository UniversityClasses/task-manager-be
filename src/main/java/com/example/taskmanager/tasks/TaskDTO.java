package com.example.taskmanager.tasks;

import com.example.taskmanager.categories.Category;
import com.example.taskmanager.categories.CategoryDTO;
import com.example.taskmanager.status.State;
import com.example.taskmanager.status.StateDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TaskDTO {
    private UUID uuid;
    private String name;
    private String description;
    private List<CategoryDTO> categories;
    private StateDTO status;

    public TaskDTO() {}

    public TaskDTO(UUID uuid, String name, String description, List<CategoryDTO> categories, StateDTO status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.status = status;
    }
}
