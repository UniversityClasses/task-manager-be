package com.example.taskmanager.tasks;

import com.example.taskmanager.category.CategoryDTO;

import java.util.List;
import java.util.UUID;

public class TaskDTO {
    private UUID uuid;
    private String name;
    private String description;
    private List<CategoryDTO> categories;
    private String status;

    public TaskDTO() {}

    public TaskDTO(UUID uuid, String name, String description, List<CategoryDTO> categories, String status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.status = status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
