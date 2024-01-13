package com.example.taskmanager.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

//    @Test
//    public void testGetAll() {
//        // Arrange
//        List<TaskDTO> mockTaskList = Arrays.asList(
//                new TaskDTO("1", "New Task 1", "description", "category", "status"),
//                new TaskDTO("2", "New Task 2", "description", "category", "status")
//        );
//        Mockito.when(taskService.getAll()).thenReturn(mockTaskList);
//
//        // Act
//        List<TaskDTO> result = taskController.getAll(null);
//
//        // Assert
//        Assertions.assertEquals(mockTaskList, result);
//    }
//
//    @Test
//    public void testCreate() {
//        // Arrange
//        TaskDTO inputTaskDTO = new TaskDTO("1", "New Task", "description", "category", "status");
//        Mockito.when(taskService.create(inputTaskDTO)).thenReturn(inputTaskDTO);
//
//        // Act
//        TaskDTO result = taskController.create(inputTaskDTO);
//
//        // Assert
//        Assertions.assertEquals(inputTaskDTO, result);
//    }
//
//    @Test
//    public void testGetOne() {
//        // Arrange
//        String taskUuid = "1";
//        TaskDTO mockTask = new TaskDTO(taskUuid, "New Task", "description", "category", "status");
//        Mockito.when(taskService.getOne(taskUuid)).thenReturn(mockTask);
//
//        // Act
//        ResponseEntity<TaskDTO> result = taskController.getOne(taskUuid);
//
//        // Assert
//        Assertions.assertEquals(mockTask, result.getBody());
//    }
//
//    @Test
//    public void testGetOneTaskNotFound() {
//        // Arrange
//        String taskUuid = "1";
//        // TODO: Change for task not found exception
//        Mockito.when(taskService.getOne(taskUuid)).thenThrow(new RuntimeException("Task not found"));
//
//        // Act
//        ResponseEntity<TaskDTO> responseEntity = taskController.getOne(taskUuid);
//
//        // Assert
//        Assertions.assertEquals(404, responseEntity.getStatusCodeValue()); // Assuming you handle TaskNotFoundException with HTTP 404
//        // You might want to include more assertions based on your actual exception handling logic
//    }
//
//
//    @Test
//    public void testEdit() {
//        // Arrange
//        TaskDTO inputTaskDTO = new TaskDTO("1", "Updated Task", "description", "category", "status");
//        Mockito.when(taskService.edit(inputTaskDTO)).thenReturn(inputTaskDTO);
//
//        // Act
//        TaskDTO result = taskController.edit(inputTaskDTO);
//
//        // Assert
//        Assertions.assertEquals(inputTaskDTO, result);
//    }
//
//    @Test
//    public void testDelete() {
//        // Arrange
//        String taskUuid = "1";
//        TaskDTO mockDeletedTask = new TaskDTO(taskUuid, "Deleted Task", "description", "category", "status");
//        Mockito.when(taskService.delete(taskUuid)).thenReturn(mockDeletedTask);
//
//        // Act
//        TaskDTO result = taskController.delete(taskUuid);
//
//        // Assert
//        Assertions.assertEquals(mockDeletedTask, result);
//    }
}
