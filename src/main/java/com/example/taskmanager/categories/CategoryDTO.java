package com.example.taskmanager.categories;

import lombok.Data;
import java.util.UUID;

@Data
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
}
