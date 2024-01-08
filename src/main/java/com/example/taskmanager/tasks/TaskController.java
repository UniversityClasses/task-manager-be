package com.example.taskmanager.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDTO> getAll(@RequestParam(value = "categoryId", required = false) List<String> categoryIdList) {
        return taskService.getAll();
    }

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO dto) {

        return taskService.create(dto);
    }

    @GetMapping("/{taskId}")
    public TaskDTO getOne(@PathVariable String taskId) {
        return taskService.getOne(taskId);
    }

    @PutMapping
    public TaskDTO edit(@RequestBody TaskDTO dto) {

        return taskService.edit(dto);
    }

    @DeleteMapping("/{taskId}")
    public TaskDTO delete(@PathVariable String taskId) {
        return taskService.delete(taskId);
    }
}
