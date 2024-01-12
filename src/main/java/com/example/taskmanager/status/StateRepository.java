package com.example.taskmanager.status;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public interface StateRepository {
    Collection<State> findAll();

    State save(State state);

    State getByUUID(String uuid);

    State edit(State stateSearched, StateDTO dto);

    State delete(State stateSearched);
}
