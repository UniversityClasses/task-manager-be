package com.example.taskmanager.category;

import java.util.UUID;

public class CategoryDTO {
    private UUID uuid;
    private String name;
    private String description;

    public CategoryDTO(UUID uuid) {
        this.uuid = uuid;
    }

    public CategoryDTO() {
    }


    public CategoryDTO(UUID uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
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
}
