package com.example.taskmanager.tasks;

import lombok.Data;

@Data
public class TaskDTO {
    private String uuid;
    private String name;
    private String description;
    private String category;
    private String status;
    private boolean deleted;

    public TaskDTO() {}

    public TaskDTO(String uuid, String name, String description, String category, String status,boolean deleted) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.category = category;
        this.status = status;
        this.deleted = deleted;
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
