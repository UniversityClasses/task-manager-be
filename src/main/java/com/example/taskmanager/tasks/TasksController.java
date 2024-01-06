package com.example.taskmanager.tasks;

import com.example.taskmanager.dtos.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDTO> getAll() {
        return this.taskService.getAll();
    }
}
