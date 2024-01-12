package com.example.taskmanager.status;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StateService {
    List<StateDTO> getAll();

    StateDTO create(StateDTO dto);

    StateDTO getOne(String uuid);

    StateDTO edit(StateDTO dto);

    StateDTO delete(String uuid);
}
