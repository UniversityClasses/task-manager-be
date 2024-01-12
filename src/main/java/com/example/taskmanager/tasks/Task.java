package com.example.taskmanager.tasks;

import com.example.taskmanager.Generics.ModelBase;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Task extends ModelBase {
    private String category;
    private Timestamp endedDate;
    private String status;

    public Task(String uuid) {
        super.setUuid(uuid);
    }

    public Task(String name, String description, String category, String status, String uuid, boolean deleted) {
        super.setName(name);
        super.setDescription(description);
        this.category = category;
        this.status = status;
        super.setUuid(uuid);
        super.setDeleted(deleted);
    }

}
