package com.example.taskmanager.tasks;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<TaskDTO> getAll(List<String> categoryIdList, List<String> statusIdList);

    TaskDTO create(TaskDTO dto);

    TaskDTO edit(TaskDTO dto);

    TaskDTO getOne(UUID uuid);

    TaskDTO delete(UUID uuid);


}
