package com.example.taskmanager.tasks;

import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.status.StatusDTO;

public class TaskDTO {
    private String uuid;
    private String name;
    private String description;
    private CategoryDTO category;
    private StatusDTO status;

    public TaskDTO() {}

    public TaskDTO(String uuid, String name, String description, CategoryDTO category, StatusDTO status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }
}
