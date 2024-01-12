package com.example.taskmanager.tasks;

import com.example.taskmanager.Generics.ModelBase;
import com.example.taskmanager.categories.Category;
import com.example.taskmanager.status.State;
import jdk.jshell.Snippet;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Task extends ModelBase {
    //private String category;
    //private String status;
    private Category category;
    private State state;
    private Timestamp endedDate;

    public Task(String uuid) {
        super.setUuid(uuid);
    }
    public Task(){}
    public Task(String name, String description, Category category, State state, String uuid, boolean deleted) {
        super.setName(name);
        super.setDescription(description);
        this.category = category;
        this.state = state;
        super.setUuid(uuid);
        super.setDeleted(deleted);
    }
    public Task(String name, String description, String category, String state, String uuid, boolean deleted) {
        super.setName(name);
        super.setDescription(description);
        this.category = new Category(category);
        this.state = new State(state);
        super.setUuid(uuid);
        super.setDeleted(deleted);
    }
}
