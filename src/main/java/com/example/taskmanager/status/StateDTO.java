package com.example.taskmanager.status;

import com.example.taskmanager.tasks.TaskDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Data
public class StateDTO {

    @NotNull(message = "Uuid cannot be null", groups = {StateDTO.UpdateValidationGroup.class})
    @Null(message = "Uuid should be null", groups = {StateDTO.CreateValidationGroup.class})
    private UUID uuid;

    @NotBlank(message="Name cannot be blank")
    @Size(max = 200, min = 5)
    private String name;

    @NotBlank(message="Name cannot be blank")
    @Size(max = 200, min = 3)
    private String description;

    private List<TaskDTO> tasks;

    public StateDTO(UUID uuid) {
        this.uuid = uuid;
    }

    public StateDTO() {}

    public StateDTO(UUID uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    public StateDTO(UUID uuid, String name, String description, List<TaskDTO> tasks) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
    }
    public interface UpdateValidationGroup{}
    public interface CreateValidationGroup{}

}
