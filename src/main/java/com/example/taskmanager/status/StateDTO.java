package com.example.taskmanager.status;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
public class StateDTO {
    private UUID uuid;
    private String name;
    private String description;

    public StateDTO(UUID uuid) {
        this.uuid = uuid;
    }

    public StateDTO() {
    }


    public StateDTO(UUID uuid, String name, String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }
}
