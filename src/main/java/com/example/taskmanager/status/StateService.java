package com.example.taskmanager.status;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface StateService {
    List<StateDTO> getAll(List<String> tasksIds);

    StateDTO create(StateDTO dto);

    StateDTO getOne(UUID uuid);

    StateDTO edit(StateDTO dto);

    StateDTO delete(UUID uuid);
}
