package com.example.taskmanager.status;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StateDTO {
    private String uuid;
    private String name;
    private String description;
    private boolean deleted;
    public StateDTO(String uuid, String name, String description,boolean deleted) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
    }
    public StateDTO(){}
}
