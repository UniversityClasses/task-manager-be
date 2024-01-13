package com.example.taskmanager.category;

import com.example.taskmanager.modelbase.ModelBase;

import java.sql.Timestamp;

public class Category extends ModelBase {
    private String categoryId;
    private String name;
    private String description;

    public Category(String uuid) {
        super(uuid);
    }

    public Category(String name, String description, String uuid) {
        super(uuid);
        this.name = name;
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
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

}
