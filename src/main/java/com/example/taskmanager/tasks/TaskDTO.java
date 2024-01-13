package com.example.taskmanager.tasks;

import java.util.UUID;

public class TaskDTO {
    private UUID uuid;
    private String name;
    private String description;
    private String category;
    private String status;

    public TaskDTO() {}

    public TaskDTO(UUID uuid, String name, String description, String category, String status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
