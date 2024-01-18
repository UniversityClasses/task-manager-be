package com.example.taskmanager.tasks;

import com.example.taskmanager.category.CategoryDTO;
import com.example.taskmanager.status.StatusDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;


public class TaskDTO {

    @NotNull(message = "Uuid cannot be null", groups = {UpdateValidationGroup.class})
    @Null(message = "Uuid should be null", groups = {CreateValidationGroup.class})
    private UUID uuid;
    @NotBlank(message="Name cannot be blank")
    @Size(max = 200, min = 3)
    private String name;
    @NotBlank(message="Description cannot be blank")
    @Size(max = 2000, min = 3)
    private String description;
    private List<CategoryDTO> categories;
    private StatusDTO status;

    public TaskDTO() {}

    public TaskDTO(UUID uuid, String name, String description, List<CategoryDTO> categories, StatusDTO status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.status = status;
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public interface CreateValidationGroup {

    }
    public interface UpdateValidationGroup {

    }
}


