package com.example.taskmanager.tasks;

import com.example.taskmanager.category.Category;
import com.example.taskmanager.modelbase.ModelBase;
import com.example.taskmanager.status.Status;

import java.sql.Timestamp;

public class Task extends ModelBase {
    private String taskId;
    private String name;
    private String description;
    private Category category;
    private Timestamp endedDate;
    private Status status;


    public Task(String uuid) {
        super(uuid);
    }

    public Task(String name, String description, Category category, Status status,String uuid) {
        super(uuid);
        this.name = name;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Timestamp getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(Timestamp endedDate) {
        this.endedDate = endedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
