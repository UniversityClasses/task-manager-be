package com.example.taskmanager.status;
import org.springframework.stereotype.Component;

@Component
public class StateMapper {
    public StateDTO toDTO(State state) {
        return new StateDTO(state.getUuid(),state.getName(),state.getDescription(),state.isDeleted());
    }

    public State toModel(StateDTO dto) {
        return new State(dto.getUuid(),dto.getName(), dto.getDescription(), dto.isDeleted());
    }
}
