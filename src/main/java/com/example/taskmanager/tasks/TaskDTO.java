package com.example.taskmanager.tasks;

import com.example.taskmanager.categories.CategoryDTO;
import com.example.taskmanager.status.StateDTO;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

@Data
public class TaskDTO {
    @NotNull(message = "Uuid cannot be null", groups = {UpdateValidationGroup.class})
    @Null(message = "Uuid should be null", groups = {CreateValidationGroup.class})
    private UUID uuid;

    @NotBlank(message="Name cannot be blank", groups = {UpdateValidationGroup.class,CreateValidationGroup.class} )
    @Size(max = 200, min = 3)
    private String name;

    @NotBlank(message="Description cannot be blank", groups = {UpdateValidationGroup.class,CreateValidationGroup.class})
    @Size(max = 2000, min = 3)
    private String description;

    private List<CategoryDTO> categories;
    private StateDTO status;

    public TaskDTO() {}

    public TaskDTO(UUID uuid, String name, String description, List<CategoryDTO> categories, StateDTO status) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.status = status;
    }

    public TaskDTO(UUID uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public interface CreateValidationGroup {

    }
    public interface UpdateValidationGroup {

    }
}
