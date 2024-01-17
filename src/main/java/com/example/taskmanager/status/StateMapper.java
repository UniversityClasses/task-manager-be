package com.example.taskmanager.status;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {
    public StateDTO toDTO(State status) {
        if (status == null) {
            return null;
        }
        return new StateDTO(status.getUuid(), status.getName(), status.getDescription());
    }

    public State toModel(StateDTO dto) {
        if (dto == null) {
            return null;
        }
        return new State(dto.getUuid(), dto.getName(), dto.getDescription());
    }
}
