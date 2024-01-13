package com.example.taskmanager.status;

import org.springframework.stereotype.Component;

@Component
public class StatusMapper {
    public StatusDTO toDTO(Status status) {
        return new StatusDTO(status.getUuid(), status.getName());
    }

    public Status toModel(StatusDTO dto) {
        return new Status(dto.getName(), dto.getUuid());
    }
}
