package com.example.taskmanager.categories;

import com.example.taskmanager.tasks.TaskDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class CategoryDTO {

    @NotNull(message = "Uuid cannot be null", groups = {CategoryDTO.UpdateValidationGroup.class})
    @Null(message = "Uuid should be null", groups = {CategoryDTO.CreateValidationGroup.class})
    private UUID uuid;

    @NotBlank(message="Name cannot be blank",groups = {
            CategoryDTO.CreateValidationGroup.class,CategoryDTO.UpdateValidationGroup.class})
    @Size(max = 200, min = 5, groups = {
            CategoryDTO.CreateValidationGroup.class,CategoryDTO.UpdateValidationGroup.class})
    private String name;

    @NotBlank(message="Description cannot be blank", groups = {
            CategoryDTO.CreateValidationGroup.class,CategoryDTO.UpdateValidationGroup.class})
    @Size(max = 2000, min = 5)
    private String description;

    private Set<TaskDTO> tasks = new HashSet<>();

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
    public CategoryDTO(UUID uuid, String name, String description, Set<TaskDTO> tasks) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
    }

    public interface UpdateValidationGroup{ }
    public interface CreateValidationGroup{ }
}
