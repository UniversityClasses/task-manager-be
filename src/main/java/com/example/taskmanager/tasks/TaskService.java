package com.example.taskmanager.tasks;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getAll();

    TaskDTO create(TaskDTO dto);

    TaskDTO edit(TaskDTO dto);

    TaskDTO getOne(String uuid);

    TaskDTO delete(String uuid);
}
