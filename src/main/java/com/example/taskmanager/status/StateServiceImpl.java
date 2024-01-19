package com.example.taskmanager.status;


import com.example.taskmanager.exceptions.StateNotFoundException;
import com.example.taskmanager.exceptions.TaskNotFoundException;
import com.example.taskmanager.tasks.Task;
import com.example.taskmanager.tasks.TaskDTO;
import com.example.taskmanager.tasks.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class StateServiceImpl implements StateService{
    @Autowired
    StateMapper stateMapper;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    TaskRepository taskRepository;
    public List<StateDTO> getAll(List<String> taskIdList) {
        List<State> states =
                (!CollectionUtils.isEmpty(taskIdList))
                        ? stateRepository.findAllByTasks_UuidIn(taskIdList):
                        stateRepository.findAll();
        return  states
                .stream()
                .map(state -> stateMapper.toDTO(state))
                .collect(Collectors.toList());
    }

    @Override
    public StateDTO create(StateDTO dto) {
        List<TaskDTO> tasksDTO = dto.getTasks();
        List<Task> tasks = Collections.emptyList();
        if(!CollectionUtils.isEmpty(tasksDTO)){
            tasks = stateRepository.findAllByUuidIn(tasksDTO.stream().map(TaskDTO::getUuid).toList());
            if(CollectionUtils.isEmpty(tasks)){
               throw new StateNotFoundException(tasksDTO.stream().map(TaskDTO::getUuid).toList().toString());
            }
        }
        State state = stateMapper.toModel(dto);
        state.setName(dto.getName());
        state.setDescription(dto.getDescription());
        state.setTasks(tasks);
        State stateSaved = stateRepository.save(state);
        return stateMapper.toDTO(stateSaved);
    }

    @Override
    public StateDTO getOne(UUID uuid) {
        Optional<State> stateSearched = stateRepository.getStatusByUuid(uuid);
        if(stateSearched.isEmpty()){
            throw new StateNotFoundException(uuid.toString());
        }
        return stateMapper.toDTO(stateSearched.get());
    }

    @Override
    public StateDTO edit(StateDTO dto) {
        Optional<State> stateEdit = stateRepository.getStatusByUuid(dto.getUuid());
        if(stateEdit.isEmpty()){
            throw new StateNotFoundException(dto.getUuid().toString());
        }
        List<Task> tasks;
        List<TaskDTO> taskDTOS = dto.getTasks();
        if(!CollectionUtils.isEmpty(taskDTOS)){
            List<UUID> taskUuids = taskDTOS.stream().map(TaskDTO::getUuid).toList();
            tasks = taskRepository.findAllByUuidIn(taskUuids);
            List<UUID> missingIds = taskUuids.stream()
                    .filter(id1 -> tasks.stream().noneMatch(id2->id2.getUuid().equals(id1)))
                    .toList();

            if(!CollectionUtils.isEmpty(missingIds)){
                throw new TaskNotFoundException(missingIds.stream().map(UUID::toString).collect(Collectors.joining(", ")));
            }
        }
        else{
            tasks = Collections.emptyList();
        }
        State state =  stateEdit.get();
        state.setName(dto.getName());
        state.setDescription(dto.getDescription());
        state.setTasks(tasks);
        stateRepository.save(state);
        return stateMapper.toDTO(state);
    }

    @Override
    public StateDTO delete(UUID uuid) {
        Optional<State> stateDeleted = stateRepository.getStatusByUuid(uuid);
        if(stateDeleted.isEmpty()){
            throw new StateNotFoundException(uuid.toString());
        }
        State deleted = stateDeleted.get();
        StateDTO stateDTO = stateMapper.toDTO(deleted);
        stateRepository.delete(deleted);
        return stateDTO;
    }
}
