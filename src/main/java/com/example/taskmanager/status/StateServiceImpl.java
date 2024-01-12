package com.example.taskmanager.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
        State stateSearched = stateRepository.getByUUID(uuid);
        if (stateSearched != null)
            return stateMapper.toDTO(stateSearched);
        else return null;
    }

    @Override
    public StateDTO edit(StateDTO dto) {
        State stateSearched = stateRepository.getByUUID(dto.getUuid());
        if (stateSearched != null){
            State updateState = stateRepository.edit(stateSearched,dto);
            return stateMapper.toDTO(updateState);
        }
        else return null;
    }

    @Override
    public StateDTO delete(String uuid) {
        State stateSearched = stateRepository.getByUUID(uuid);
        if (stateSearched != null){
            State deletedState = stateRepository.delete(stateSearched);
            return stateMapper.toDTO(deletedState);
        }
        else return null;
    }
}
