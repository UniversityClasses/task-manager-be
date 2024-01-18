package com.example.taskmanager.status;

import com.example.taskmanager.exceptions.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StateServiceImpl implements StateService{
    @Autowired
    StateMapper stateMapper;
    @Autowired
    StateRepository stateRepository;
    public List<StateDTO> getAll() {
        return  stateRepository
                .findAll()
                .stream()
                .map(state -> stateMapper.toDTO(state))
                .collect(Collectors.toList());
    }

    @Override
    public StateDTO create(StateDTO dto) {
        State state = stateMapper.toModel(dto);
        State savedState = stateRepository.save(state);
        return stateMapper.toDTO(savedState);
    }

    @Override
    public StateDTO getOne(String uuid) {
        State stateSearched = null;//stateRepository.getByUUID(uuid);
        if (stateSearched != null)
            return stateMapper.toDTO(stateSearched);
        else return null;
    }

    @Override
    public StateDTO edit(StateDTO dto) {
        State stateSearched = null;//stateRepository.getByUUID(dto.getUuid());
        if (stateSearched != null){
            State updateState = null;//stateRepository.edit(stateSearched,dto);
            return stateMapper.toDTO(updateState);
        }
        else return null;
    }

    @Override
    public StateDTO delete(String uuid) {
        Optional<State> optionalState = null;//Optional.ofNullable(stateRepository.getByUUID(uuid));
        State stateSearched = optionalState.orElseThrow(() -> new StateNotFoundException("State Not Found with UUID: " + uuid));
        State deletedState = null;//stateRepository.delete(stateSearched);
        return stateMapper.toDTO(deletedState);
    }
}
