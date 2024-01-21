package com.example.taskmanager.status;

import org.springframework.stereotype.Component;

@Component
public class StatusMapper {
    public StatusDTO toDTO(Status status) {
        if (status == null) {
            return null;
        }
        return new StatusDTO(status.getUuid(), status.getName(), status.getDescription());
    }

    public Status toModel(StatusDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Status(dto.getUuid(), dto.getName(), dto.getDescription());
    }
}
