package com.example.taskmanager.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<TaskDTO> getAll(
            @RequestParam(value = "categoryId", required = false) List<String> categoryIdList,
            @RequestParam(value = "statusId", required = false) List<String> statusIdList) {
        return taskService.getAll(categoryIdList, statusIdList);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public TaskDTO create(@Validated(TaskDTO.CreateValidationGroup.class) @RequestBody TaskDTO dto) {
        return taskService.create(dto);
    }

    @GetMapping("/{uuid}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<TaskDTO> getOne(@PathVariable String uuid) {
        try {
            TaskDTO task = taskService.getOne(UUID.fromString(uuid));
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(task);
        } catch(Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public TaskDTO edit(@Validated(TaskDTO.UpdateValidationGroup.class)  @RequestBody TaskDTO dto) {
        return taskService.edit(dto);
    }

    @DeleteMapping("/{uuid}")
    @PreAuthorize("hasRole('ADMIN')")
    public TaskDTO delete(@PathVariable String uuid) {
        return taskService.delete(UUID.fromString(uuid));
    }
}
