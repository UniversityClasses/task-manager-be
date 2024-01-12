package com.example.taskmanager.categories;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CategoryDTO {
    private String uuid;
    private String name;
    private String description;
    private boolean deleted;
    public CategoryDTO(String uuid, String name, String description,boolean deleted) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
    }
    public CategoryDTO(){}
}
