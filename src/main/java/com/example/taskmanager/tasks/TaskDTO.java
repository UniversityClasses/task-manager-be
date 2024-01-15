package com.example.taskmanager.tasks;

import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.status.StatusDTO;

import java.util.List;
import java.util.UUID;

public class TaskDTO {
    private UUID uuid;
    private String name;
    private String description;
    private List<CategoryDTO> categories;
    private StatusDTO status;

    public TaskDTO() {}

    public TaskDTO(UUID uuid, String name, String description, List<CategoryDTO> categories, StatusDTO status) {
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

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }
}
