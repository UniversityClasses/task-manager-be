package com.example.taskmanager.status;
import com.example.taskmanager.tasks.Task;
import com.example.taskmanager.tasks.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StateMapper {
    public StateDTO toDTO(State status) {
        List<Task> tasks = status.getTasks();
        return new StateDTO(
                status.getUuid(),
                status.getName(),
                status.getDescription(),
                extractTasks(tasks));
    }

    public State toModel(StateDTO dto) {
        return new State(dto.getUuid(), dto.getName(), dto.getDescription(),null);
    }

    private List<TaskDTO> extractTasks(List<Task> tasks) {
        List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();
        for (Task task : tasks) {
            taskDTOs.add(new TaskDTO(task.getUuid(), task.getName(), task.getDescription()));
        }
        return taskDTOs;
    }
}
