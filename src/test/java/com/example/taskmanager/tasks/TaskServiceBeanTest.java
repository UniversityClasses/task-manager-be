package com.example.taskmanager.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceBeanTest {
//
//    @InjectMocks
//    private TaskServiceBean taskService;
//
//    @Mock
//    private TaskMapper taskMapper;
//
//    @Mock
//    private TaskRepository taskRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetAll() {
//        // Arrange
//        when(taskRepository.findAll()).thenReturn(Collections.singletonList(new Task("uuid", "TaskName", "TaskDescription", "Category", "Status")));
//
//        // Act
//        taskService.getAll();
//
//        // Assert
//        verify(taskRepository, times(1)).findAll();
//        verify(taskMapper, times(1)).toDTO(any(Task.class));
//    }
//
//    @Test
//    public void testCreate() {
//        // Arrange
//        TaskDTO taskDTO = new TaskDTO("uuid", "TaskName", "TaskDescription", "Category", "Status");
//        Task task = new Task("uuid", "TaskName", "TaskDescription", "Category", "Status");
//
//        when(taskMapper.toModel(taskDTO)).thenReturn(task);
//        when(taskRepository.save(task)).thenReturn(task);
//        when(taskMapper.toDTO(task)).thenReturn(taskDTO);
//
//        // Act
//        TaskDTO result = taskService.create(taskDTO);
//
//        // Assert
//        verify(taskRepository, times(1)).save(task);
//        verify(taskMapper, times(1)).toDTO(task);
//        assertEquals(taskDTO, result);
//    }
//
//    @Test
//    public void testEdit() {
//        // Arrange
//        TaskDTO taskDTO = new TaskDTO("uuid", "UpdatedTaskName", "UpdatedTaskDescription", "UpdatedCategory", "UpdatedStatus");
//        Task existingTask = new Task("uuid", "TaskName", "TaskDescription", "Category", "Status");
//
//        when(taskRepository.findOne(any())).thenReturn(Optional.of(existingTask));
//        when(taskRepository.save(existingTask)).thenReturn(existingTask);
//        when(taskMapper.toDTO(existingTask)).thenReturn(taskDTO);
//
//        // Act
//        TaskDTO result = taskService.edit(taskDTO);
//
//        // Assert
//        verify(taskRepository, times(1)).save(existingTask);
//        verify(taskMapper, times(1)).toDTO(existingTask);
//        assertEquals(taskDTO, result);
//    }
//
//    @Test
//    public void testEditTaskNotFound() {
//        // Arrange
//        TaskDTO taskDTO = new TaskDTO("uuid", "UpdatedTaskName", "UpdatedTaskDescription", "UpdatedCategory", "UpdatedStatus");
//
//        when(taskRepository.findOne(any())).thenReturn(Optional.empty());
//
//        // Act and Assert
//        // TODO: Update for TaskNotFoundException
//        assertThrows(RuntimeException.class, () -> taskService.edit(taskDTO));
//    }

}
