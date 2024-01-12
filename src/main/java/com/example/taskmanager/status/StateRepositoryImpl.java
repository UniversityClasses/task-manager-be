package com.example.taskmanager.status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StateRepositoryImpl implements StateRepository{
    public static final List<State> states = new ArrayList<>(Arrays.asList(
            new State("state559ffa0a-5bb7-4207-a14e-93090623dec1","State1","description1",false),
            new State("state559ffa0a-5bb7-4207-a14e-93090623dec2","State2","description2",false),
            new State("state559ffa0a-5bb7-4207-a14e-93090623dec3","State3","description3",true)
    ));
    @Override
    public Collection<State> findAll() {
        return states.stream().filter(state -> !state.isDeleted()).collect(Collectors.toList());
    }

    @Override
    public State save(State dto) {
        State createdState = new State(dto.getUuid(),dto.getName(),dto.getDescription(),false);
        states.add(createdState);
        return createdState;
    }

    @Override
    public State getByUUID(String uuid) {
        State searched = null;
        for (State state : states) {
            if (state.getUuid().equals(uuid)) {
                searched = state;
            }
        }
        return searched;
    }

    @Override
    public State edit(State stateSearched, StateDTO dto) {
        stateSearched.setName(dto.getName());
        stateSearched.setDescription(dto.getDescription());
        return stateSearched;
    }

    @Override
    public State delete(State stateSearched) {
        stateSearched.setDeleted(true);
        return stateSearched;
    }
}
