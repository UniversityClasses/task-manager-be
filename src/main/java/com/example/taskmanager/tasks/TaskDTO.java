package com.example.taskmanager.tasks;

import java.sql.Timestamp;

public class TaskDTO {
    private String uuid;
    private String name;
    private String description;
    private String category;
    private Timestamp endedDate;
    private String status;

    public TaskDTO() {}

    public TaskDTO(String uuid, String name, String description, String category, Timestamp endedDate, String status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.category = category;
        this.endedDate = endedDate;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(Timestamp endedDate) {
        this.endedDate = endedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
