package com.example.taskmanager.tasks;

import com.example.taskmanager.categories.Category;
import com.example.taskmanager.status.State;
import lombok.Data;

@Data
public class TaskDTO {
    private String uuid;
    private String name;
    private String description;
    private String category;
    private String state;
    private boolean deleted;

    public TaskDTO() {}

    public TaskDTO(String uuid, String name, String description, String category, String state,boolean deleted) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.category = category;
        this.state = state;
        this.deleted = deleted;
    }
}
